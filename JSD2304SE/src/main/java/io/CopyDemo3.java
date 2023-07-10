package io;

import java.io.*;

/**
 * java将流分为两类：
 * 节点流与处理流
 *节点流:又称为低级流,特点:实际连接程序与另一端的"管道",负责实际读写数据的流.
 *         IO一定是建立在某个低级流的基础上进行的.
 *         文件流就是低级流,它们是实际连接程序与文件的管道,负责读写文件数据
 *
 *   处理流:又称为高级流,特点:不能独立存在,必须连接在其他流上,目的是当数据经过该
 *         流时对数据进行某种加工处理,简化我们的同等操作
 *   实际开发中我们经常串联一组高级流最终到某个低级流上,是的读写数据的过程中以流水线
 *    式的操作对数据加工处理,这个过程也称为"流的连接"
 *
 *
 *   缓冲流
 *   java.io.BufferedInputStream和BufferedOutputStream
 *   缓冲流是一对高级流,在流连接中的作用:保证读写效率
 *
 */
public class CopyDemo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./img.jpg");
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream("./img_cp.jpg");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int d;
        long start = System.currentTimeMillis();
        while ((d = bis.read()) != -1){
            bos.write(d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制成功！耗时："+(end-start)+"ms");
    }
}
