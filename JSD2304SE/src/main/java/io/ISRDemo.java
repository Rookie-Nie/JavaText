package io;

import java.io.*;

/***
 * 使用InputStreamReader读取文本数据
 */
public class ISRDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("osw.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        /*
        int read()
        对于字符流而言，该方法用于读取1个字符，返回的int值对应的2进制
        是"低16位有效"，实际返回的就是一个char。
        但是如果返回的int值为整数-1，依然表达流读取到了末尾
         */
        int d;
        while ((d = isr.read()) != -1){
            System.out.print((char)d);
        }
        isr.close();
    }
}
