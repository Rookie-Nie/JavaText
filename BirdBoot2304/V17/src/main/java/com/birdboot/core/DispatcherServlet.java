package com.birdboot.core;

import com.birdboot.annotation.Controller;
import com.birdboot.annotation.RequestMapping;
import com.birdboot.controller.UserController;
import com.birdboot.http.HttpServletRequest;
import com.birdboot.http.HttpServletResponse;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
/**
 * 该类是SpringMVC框架与Tomcat整合时的一个关键类
 * Tomcat处理业务原生的都是调用继承了HttpServlet的类来完成，此时需要进行很多配置
 * 以及使用时要作很多重复性劳动。
 * SpringMVC框架提供的该类也是继承了HttpServlet的，使用它来接收处理请求的工作。
 */
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
        String path = request.getRequestURI();
        System.out.println("请求路径："+path);

        //首先判断是否为业务
        try {
            File dir = new File(DispatcherServlet.class.getClassLoader().getResource(".").toURI());
            File controllerDir = new File(dir,"com/birdboot/controller");

            File[] filesNames = controllerDir.listFiles(f->f.getName().endsWith(".class"));
            String packageName = "com.birdboot.controller";
            for (File fileName : filesNames){
                String className = fileName.getName().substring(0,fileName.getName().indexOf("."));
                Class cls = Class.forName(packageName+"."+className);
                if (cls.isAnnotationPresent(Controller.class)){
                    Object obj = cls.newInstance();
                    Method[] methods = cls.getMethods();
                    for (Method method : methods){
                        if (method.isAnnotationPresent(RequestMapping.class)){
                            RequestMapping rm = method.getAnnotation(RequestMapping.class);
                            String str = rm.value();
                            if (str.equals(path)){
                                method.invoke(obj,request,response);
                                return;
                            }
                        }
                    }
                }
            }
        } catch (URISyntaxException | ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        File file = new File(staticDir, path);
        if (file.isFile()) {
            response.setStatusCode(200);
            response.setStatusReason("OK");
            response.setContentFile(file);
            response.addHeader("Server", "BirdWebServer");
        } else {
            response.setStatusCode(404);
            response.setStatusReason("NotFound");
            response.setContentFile(new File(staticDir, "404.html"));
            response.addHeader("Server", "BirdWebServer");
        }
    }
}
