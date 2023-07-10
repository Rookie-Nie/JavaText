package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 复制文件
 */

public class CopyDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./img.jpg");
        FileOutputStream fos = new FileOutputStream("./img_cp.jpg");

        int d;
        /*
            System.currentTimeMillis()
            返回当前系统时间，时间是一个long值，表示当前系统的UTC时间
            UTC:世界协调时
            计算标准:自1970-01-01 00:00:00到表达的时间所经过的毫秒
         */
        long start = System.currentTimeMillis();
        while ((d = fis.read()) != -1){
            fos.write(d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制成功！耗时："+(end-start)+"ms");
    }
}
