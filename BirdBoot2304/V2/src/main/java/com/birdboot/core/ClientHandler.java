package com.birdboot.core;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
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
            InputStream in = socket.getInputStream();

            char pre = 'a',cur = 'a';
            StringBuilder builder = new StringBuilder();
            int d;
            while ((d = in.read()) != -1){
                cur = (char)d;
                if(pre == 13 && cur == 10){
                    break;
                }
                builder.append(cur);
                pre = cur;
            }
            String line = builder.toString().trim();
            System.out.println("请求行："+line);

            String method;
            String uri;
            String protocol;
//            method = line.substring(0,line.indexOf(" "));
//            uri = line.substring(line.indexOf(" ")+1,line.lastIndexOf(" "));
//            protocol = line.substring(line.lastIndexOf(" ")+1,line.length());
            String[] data = line.split("\\s");
            method = data[0];
            uri = data[1];
            protocol = data[2];

            System.out.println("method:"+method);
            System.out.println("uri:"+uri);
            System.out.println("protocol:" +protocol);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
