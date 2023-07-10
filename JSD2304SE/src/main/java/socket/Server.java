package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室服务端
 */

public class Server {
    /**
     *  java.net.ServerSocket
     *  ServerSocket主要有两个作用
     *  1:向系统申请服务端口,客户端就是通过这个端口与服务端建立连接的
     *  2:监听端口等待客户端的连接
     *    一旦一个客户端与服务端建立连接,此时会创建一个Socket与该客户端交互
     */
    private ServerSocket serverSocket;
    private List<PrintWriter> allOut = new ArrayList<>();
    public Server(){
        try {
            System.out.println("正在启动服务端。。。");
            /*
                实例化ServerSocket时要指定服务端口,如果该端口已经被操作
                系统其他程序占用时会抛出异常:
                java.net.BingException():address already in use
             */
            serverSocket = new ServerSocket(8088);
            System.out.println("服务端启动完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        try {
            while (true) {
                System.out.println("等待客户端连接。。。");
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端连接了！");
                //启动一个线程来处理与该客户端的交互
                ClientHandler handler = new ClientHandler(socket);
                Thread t = new Thread(handler);

                t.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    /**
     * 该线程任务是与特定的客户端进行交互
     */
    private class ClientHandler implements Runnable{
        private Socket socket;
        private String host;

        public  ClientHandler(Socket socket){
            this.socket = socket;
            host = socket.getInetAddress().getHostAddress();
        }

        @Override
        public void run() {
            PrintWriter pw = null;
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);

                //通过socket获取输出流，用于将信息发送给客户端
                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out,StandardCharsets.UTF_8);
                BufferedWriter bw = new BufferedWriter(osw);
                pw = new PrintWriter(bw,true);
                //临界资源适合作为同步监视器对象
                //抢谁就锁谁
                synchronized (allOut) {
                    //将该输出流存入共享结婚，便于广播信息
                    allOut.add(pw);
                }
                sendMessage(host+"上线了，当前在线人数："+allOut.size());

                String message ;
                while ((message = br.readLine()) != null){
                    sendMessage(host+"说："+message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                //处理该客户端断开后的操作
                synchronized (allOut) {
                    allOut.remove(pw);
                }

                sendMessage(host+"下线了，当前在线人数："+allOut.size());

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //广播给定的消息到所有客户端
    private void sendMessage(String message){
        System.out.println(message);
        //将消息发送给客户端
//                    allOut.forEach(e->e.println(host+"说："+message));
        synchronized (allOut) {
            for (PrintWriter e : allOut) {
                e.println(message);
            }
        }
    }
}
