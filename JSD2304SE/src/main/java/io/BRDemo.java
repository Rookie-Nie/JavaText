package io;

import java.io.*;

/**
 *使用缓冲字符输入流按行读取字符串
 */
public class BRDemo {
    public static void main(String[] args) throws IOException {
        //将当前源代码按行读取出来并输出到控制台上
        FileInputStream fis = new FileInputStream("./src/main/java/io/BRDemo.java");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        /*
            BufferedReader提供的独有方法:
            String readLine()
            当第一次调用readLine()方法时,缓冲字符输入流会一次性读取8192个字符(块读)
            并存入内部的char数组中,然后从数组一个字符开始直到找到换行符位置,然后将
            之前的内容转换为一个字符串返回.(看起来像是读取了一行字符串)
            当第二次调用readLine()则直接从上次遇到换行符的位置开始再继续寻找下一个
            换行符为止,将之间的内容转换为一个字符串返回

            如果流读取到了末尾,此时该方法会返回null

         */
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
