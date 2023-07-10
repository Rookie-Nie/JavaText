package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class NoteDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("note.txt",true);
        /*
            FileOutputStream(File file)
            FileOutputStream(String path)
            上述两种构造器创建文件流为覆盖模式,即:如果指定的文件存在会将
            该文件原有内容全部删除

            FileOutputStream(File file,boolean append)
            FileOutputStream(String path,boolean append)
            如果第二个参数为true,则指定为追加模式.此时创建文件流时如果指定的
            文件存在则内容会全部保留,新写入的内容会被追加到文件中
         */
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你想要的文本（输入exit退出）：");
        while (true){
            String str = scan.nextLine();
            if ("exit".equalsIgnoreCase(str)){
                break;
            }
            byte[] data = str.getBytes(StandardCharsets.UTF_8);
            fos.write(data);
        }
        System.out.println("退出成功！");
        fos.close();
    }
}
