package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class NoteDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("note2.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw,true);

        Scanner scan = new Scanner(System.in);
        System.out.println("请输入您需要输入的数据（单独输入exit时退出程序 ：）");
        while (true){
            String str = scan.nextLine();
            if("exit".equalsIgnoreCase(str)){
                break;
            }
            pw.println(str);
        }
        pw.close();
        System.out.println("写入完成！");
    }
}
