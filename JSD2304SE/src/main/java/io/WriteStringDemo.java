package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        //向文件中写入一行中文
        FileOutputStream fos = new FileOutputStream("test.txt");
        String line = "清晨来临，大雾散尽。";
        byte[] data = line.getBytes(StandardCharsets.UTF_8);
        fos.write(data);

        fos.write("后来，不止清晨；不止大雾！".getBytes(StandardCharsets.UTF_8));
        System.out.println("写出完毕！");
        fos.close();
    }
}
