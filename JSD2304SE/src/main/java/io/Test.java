package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("test.txt");
        for (int i = 0;i<26;i++){
            fos.write(65+i);
        }
        System.out.println("写出完毕！");
        fos.close();//使用完要关闭
    }
}
