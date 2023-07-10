package homework.sync;

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
            System.out.println("连接服务器成功！");
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

            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入对话内容（单独输入exit退出）：");
            while (true){
                String line = scanner.nextLine();
                if ("exit".equalsIgnoreCase(line)){
                    break;
                }
                pw.println(line);
            }
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
        Client client = new Client();
        client.start();
    }
}
