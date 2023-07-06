package com.birdboot.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpServletResponse {
    private Socket socket;
    //状态行相关信息
    private int statusCode;//状态代码
    private String statusReason;//状态描述
    //响应头相关信息
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
        println("Content-Type: text/html");
        println("Content-Length: "+contentFile.length());
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
    }
}
