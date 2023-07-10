package io;

import java.io.*;

public class Test2 {
    public static void main(String[] args) throws IOException {
        File dir = new File("./src/main/java/io");
//
        if (dir.isDirectory()){
            File[] files = dir.listFiles(f->f.getName().endsWith(".java"));
            for (File file : files){
                    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    br.close();
            }
        }
        System.out.println("读取完毕！");
    }
}
