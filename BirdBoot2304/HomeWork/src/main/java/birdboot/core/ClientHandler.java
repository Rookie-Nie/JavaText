package birdboot.core;




import birdboot.http.EmptyRequestException;
import birdboot.http.HttpServletRequest;
import birdboot.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.URISyntaxException;

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
            HttpServletResponse response = new HttpServletResponse(socket);
            //2、处理请求
            DispatcherServlet.getInstance().service(request,response);
            //3、发送响应
            response.response();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (EmptyRequestException e) {

        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
