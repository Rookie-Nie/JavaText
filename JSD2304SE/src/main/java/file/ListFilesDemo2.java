package file;

import java.io.File;
import java.io.FileFilter;
/**
 * 有条件的获取一个目录中的子项
 */
public class ListFilesDemo2 {
    public static void main(String[] args) {
        //获取当前目录下的所有文本文件（文件名是以“.txt”结尾的）
        File dir = new File(".");
        if (dir.isDirectory()){
            /*
                重载的listFiles方法要求传入一个文件过滤器
                该方法会将File对象表示的目录中所有满足过滤器条件的子项返回
             */
            File[] subs = dir.listFiles( f -> f.getName().endsWith(".txt"));
            for (File sub : subs){
                System.out.println(sub.getName());
            }
        }

    }
}
