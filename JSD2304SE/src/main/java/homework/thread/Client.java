package homework.thread;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    private Socket socket;

    public Client(){
        try {
            System.out.println("正在连接服务器。。。");
            socket = new Socket("localhost",8088);
            System.out.println("服务器连接成功。。。");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void start(){
        try {
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw,true);

            Scanner scan = new Scanner(System.in);
            System.out.println("输入对话内容（单独输入exit退出）：");
            while (true){
                String line = scan.nextLine();
                if ("exit".equalsIgnoreCase(line)){
                    break;
                }
                pw.println(line);
            }
            System.out.println("对话结束！");
            pw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

}
