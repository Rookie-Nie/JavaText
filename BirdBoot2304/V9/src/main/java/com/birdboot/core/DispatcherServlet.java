package com.birdboot.core;

import com.birdboot.http.HttpServletRequest;
import com.birdboot.http.HttpServletResponse;

import java.io.File;
import java.net.URISyntaxException;

public class DispatcherServlet {
    //单例化
    private static DispatcherServlet instance = new DispatcherServlet();
    private DispatcherServlet(){}
    public static DispatcherServlet getInstance(){
        return instance;
    }

    private static File baseDir;//类加载路径
    private static File staticDir;//类加载路径下的static目录

    static {
        try {
            baseDir = new File(ClientHandler.class.getClassLoader().getResource(".").toURI());
            staticDir = new File(baseDir,"static");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void service(HttpServletRequest request, HttpServletResponse response){
        String path = request.getUri();
        System.out.println("请求路径："+path);

        File file = new File(staticDir,path);

        if (file.isFile()){
            response.setStatusCode(200);
            response.setStatusReason("OK");
            response.setContentFile(file);
            response.addHeader("Content-Type","text/html");
            response.addHeader("Content-Length",file.length()+"");
            response.addHeader("Server","BirdWebServer");
        }else {
            response.setStatusCode(404);
            response.setStatusReason("NotFound");
            response.setContentFile(new File(staticDir,"404.html"));
            response.addHeader("Content-Type","text/html");
            response.addHeader("Content-Length",file.length()+"");
            response.addHeader("Server","BirdWebServer");
        }
    }
}
