package com.birdboot.core;


import com.birdboot.http.HttpServletRequest;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
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

            //3、发送响应

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
