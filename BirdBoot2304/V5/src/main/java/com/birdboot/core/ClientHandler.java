package com.birdboot.core;


import com.birdboot.http.HttpServletRequest;

import java.io.*;
import java.net.Socket;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 该线程任务负责与指定的客户端(浏览器)完成一次HTTP交互
 * HTTP协议要求浏览器与服务端采取一问一答的模式，因此这里的交互流程分为三步：
 * 1：解析请求
 * 2：处理请求
 * 3：发送响应
 */
public class ClientHandler implements Runnable{
    private Socket socket;

    public ClientHandler(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //1、解析请求
            HttpServletRequest request = new HttpServletRequest(socket);
            String path = request.getUri();
            System.out.println("请求路径："+path);
            //2、处理请求
            File baseDir = new File(
                    ClientHandler.class.getClassLoader().getResource(".").toURI()
            );
            File staticDir = new File(baseDir,"static");
//            File file = new File(staticDir,"index.html");
            File file = new File(staticDir,path);
            //3、发送响应
            OutputStream out = socket.getOutputStream();

            String line = "HTTP/1.1 200 OK";
            byte[] data = line.getBytes(StandardCharsets.ISO_8859_1);
            out.write(data);
            out.write(13);
            out.write(10);

            line = "Content-Type: text/html";
            data = line.getBytes(StandardCharsets.ISO_8859_1);
            out.write(data);
            out.write(13);
            out.write(10);

            line = "Content-Length: "+file.length();
            data = line.getBytes(StandardCharsets.ISO_8859_1);
            out.write(data);
            out.write(13);
            out.write(10);

            out.write(13);
            out.write(10);

            FileInputStream fis =new FileInputStream(file);
            int len = 0;
            byte[] buf =new byte[1024*10];
            while ((len = fis.read(buf)) != -1){
                out.write(buf,0,len);
            }

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws URISyntaxException {
        File baseDir = new File(
                ClientHandler.class.getClassLoader().getResource(".").toURI()
        );
        System.out.println(baseDir);
    }
}
