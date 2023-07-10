package file;

import java.io.File;
/**
 * 访问一个目录中的所有子项
 */
public class ListFilesDemo {
    public static void main(String[] args) {
        //访问当前目录中的所有子项
        File dir = new File(".");
        /*
            boolean isFile()
            判断当前File对象表示的是否为一个实际存在的文件

            boolean isDirectory()
            判断当前File对象表示的是否为一个实际存在的目录(文件夹)
         */
        if (dir.isDirectory()){
            /*
                File[] listFiles()
                获取当前File对象表示的目录中的所有子项.
                返回一个File数组,数组中每个元素(一个File对象)表示该目录
                中的一个子项
             */
            File[] subs = dir.listFiles();
            for (File sub : subs){
                System.out.println(sub.getName());
            }
        }
    }
}
