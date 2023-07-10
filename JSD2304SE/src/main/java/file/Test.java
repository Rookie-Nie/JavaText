package file;

import java.io.File;
import java.io.IOException;
/*
    创建100个文件，文件名为test1。txt~test100.txt
 */
public class Test {
    public static void main(String[] args) throws IOException {
        for (int i = 1;i<=100;i++){
            File file = new File("./test"+i+".txt");
            if (!file.exists())
                file.createNewFile();
        }
        System.out.println("创建完毕！");



    }
}
