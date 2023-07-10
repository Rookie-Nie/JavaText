package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * 缓冲字符流
 * java.io.BufferedWriter与BufferedReader
 *
 * 具有自动行刷新功能的缓冲字符输出流
 * java.io.PrintWriter
 * 其内部总是链接BufferedWriter作为缓冲功能
 *
 * 缓冲流以块读写形式保证读写效率。并且可以按行读写字符串
 *
 */
public class PWDemo1 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //向文件pw.txt中按行写出字符串
        /*
            PrintWriter提供了直接对文件进行写操作的构造器
            PrintWriter(File file)
            PrintWriter(String path)
         */
        PrintWriter pw = new PrintWriter("pw.txt", "UTF-8");
        pw.println("是的我看见到处是阳光");
        pw.println("快乐在城市上空飘扬");
        System.out.println("写出完毕");
        pw.close();

    }
}
