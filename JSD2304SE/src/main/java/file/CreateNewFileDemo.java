package file;

import java.io.File;
import java.io.IOException;
/**
 * 创建一个新文件
 */
public class CreateNewFileDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("./text.txt");
        /*
            create:创建
            file:文件

            boolean createNewFile()
            当且仅当File表示的路径下不存在且实际创建出该文件时返回true

            boolean exists()
            判断当前File表示的路径下是否真实存在该文件或目录，如果存在则返回true
         */
        if(file.exists()){
            System.out.println("文件已存在！");
        }else {
            file.createNewFile();
            System.out.println("创建成功！");
        }
    }
}
