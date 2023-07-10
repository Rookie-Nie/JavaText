package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 在流连接中使用PrintWriter
 */
public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        /*
            文件流:字节流，低级流
            作用:连接文件，并将字节写入到文件中
         */
        FileOutputStream fos = new FileOutputStream("pw2.txt");
        /*
            转换流:字符流，高级流
            作用:
            1:衔接字节与其他字符流
            2:将写出的字符按照指定的字符集转换为字节
         */
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        /*
            缓冲字符流:字符流，高级流
            作用:
            块写文本数据保证写出效率的(内部默认有一个长度8192的char数组)
         */
        BufferedWriter bw = new BufferedWriter(osw);
        /*
            PrintWriter:字符流，高级流
            作用:
            1:按行写出字符串
            2:自动行刷新
         */
        PrintWriter pw = new PrintWriter(bw);

        pw.println("嘻嘻");
        pw.println("嘿嘿");
        pw.println("呵呵");
        pw.println("哇哇");
        System.out.println("写入完毕！");
        pw.close();
    }
}
