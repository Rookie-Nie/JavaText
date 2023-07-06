package com.birdboot.http;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HttpServletResponse {
    private static MimetypesFileTypeMap mftm = new MimetypesFileTypeMap();

    private Socket socket;
    //状态行相关信息
    private int statusCode;//状态代码
    private String statusReason;//状态描述
    //响应头相关信息
    //key：响应头的名字  value：响应头对应的值
    private Map<String,String> headers = new HashMap<>();
    //响应正文相关信息
    private File contentFile;//正文对应实体文件


    public HttpServletResponse(Socket socket){
        this.socket = socket;
    }

    public void response() throws IOException {
        //1、发送状态行
        sendStatusLine();
        //2、发送响应头
        sendHeaders();
        //3、发送响应正文
        sendContent();

    }

    private void sendStatusLine() throws IOException {
        println("HTTP/1.1"+" "+statusCode+" "+statusReason);
    }
    private void sendHeaders() throws IOException {
        //遍历headers将所有待发送的响应头发送给客户端
        Set<Map.Entry<String,String>> entrySet = headers.entrySet();
        for (Map.Entry<String,String> entry : entrySet){
            String key = entry.getKey();
            String value = entry.getValue();
            println(key+": "+value);
        }
        //单独发送回车+换行，表示消息头发送结束
        println("");
    }
    private void sendContent() throws IOException {
        OutputStream out = socket.getOutputStream();
        FileInputStream fis =new FileInputStream(contentFile);
        int len = 0;
        byte[] buf =new byte[1024*10];
        while ((len = fis.read(buf)) != -1){
            out.write(buf,0,len);
        }
    }

    private void println(String line) throws IOException {
        OutputStream out = socket.getOutputStream();
        byte[] data = line.getBytes(StandardCharsets.ISO_8859_1);
        out.write(data);
        out.write(13);
        out.write(10);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public File getContentFile() {
        return contentFile;
    }

    public void setContentFile(File contentFile) {
        this.contentFile = contentFile;

        addHeader("Content-Type", mftm.getContentType(contentFile));
        addHeader("Content-Length",contentFile.length()+"");
    }

    public void addHeader(String name,String value){
        headers.put(name, value);
    }
}
