package socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 聊天室客户端
 */
public class Client {
    /*
        java.net.Socket 套接字
        1该类封装了TCP协议的通讯细节,我们使用它可以与远端计算机建立连接并进行
        可靠的传输通讯.

     */
    private Socket socket;
    public Client(){
        try {
            System.out.println("正在连接服务端。。。。");
            /*
                Socket的实例化时需要传入两个参数:
                1:服务器的IP地址
                2:服务端应用程序打开的端口
                我们通过IP地址可以找到服务器在网络中的位置,通过端口找到运行在
                服务器上的服务端应用程序
             */
            socket = new Socket("localhost",8088);
            System.out.println("与服务器建立连接！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){
        try {
            //启动用来读取服务端消息的线程
            ServerHandler serverHandler = new ServerHandler();
            Thread t = new Thread(serverHandler);
            t.setDaemon(true);
            t.start();

            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw,true);

            Scanner scan = new Scanner(System.in);
            System.out.println("输入对话内容（单独输入exit退出）:");
            while (true){
                String line = scan.nextLine();
                if ("exit".equalsIgnoreCase(line)){
                    break;
                }
                pw.println(line);

            }
            pw.close();
            System.out.println("发送完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();//实例化客户端
        client.start();//启动客户端
    }

    private class ServerHandler implements Runnable{
        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in,StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);

                String message ;
                while ((message = br.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
