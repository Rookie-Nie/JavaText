package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 缓冲的写缓冲区问题
 */
public class BosFlushDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("bos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        String line = "super idol的笑容，都没你的甜";
        byte[] data = line.getBytes(StandardCharsets.UTF_8);
        bos.write(data);
         /*
            flush:冲水
            void flush()
            强制将缓冲区中已经缓存的数据全部写出



            flush方法是在接口Flushable上定义的,而OutputStream实现了该接口
            java中所有的输出流都有flush方法.
            并非所有输出流的flush都有实质作用,而更多的是为了将flush动作传递
            下去,最终传递给缓冲流来真正完成清空缓冲区操作.

         */
        //bos.flush();
        System.out.println("写出结束！");
        bos.close();
    }
}
