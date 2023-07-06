package birdboot.core;

import birdboot.controller.UserController;
import birdboot.http.HttpServletRequest;
import birdboot.http.HttpServletResponse;

import java.io.File;
import java.net.URISyntaxException;

public class DispatcherServlet {
    //单例化
    private static DispatcherServlet instance = new DispatcherServlet();
    private DispatcherServlet(){}
    public static DispatcherServlet getInstance(){
        return instance;
    }


    private static File baseDir;
    private static File staticFile;
    static {
        try {
            baseDir =new File(ClientHandler.class.getClassLoader().getResource(".").toURI());
            staticFile = new File(baseDir,"static");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void service(HttpServletRequest request, HttpServletResponse response){
        String path = request.getRequestURI();
        System.out.println("请求路径："+path);

        if ("/regUser".equals(path)){
            UserController controller = new UserController();
            controller.reg(request,response);
        }else if("/loginUser".equals(path)){
            UserController controller = new UserController();
            controller.login(request,response);
        }else {
            File file = new File(staticFile, path);
            if (file.isFile()) {
                response.setStatusCode(200);
                response.setStatusReason("OK");
                response.setContentFile(file);
                response.addHeader("Server", "BirdWebServer");
            } else {
                response.setStatusCode(404);
                response.setStatusReason("NotFound");
                response.setContentFile(new File(staticFile, "404.html"));
                response.addHeader("Server", "BirdWebServer");
            }
        }
    }
}
