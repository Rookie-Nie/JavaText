package file;

import java.io.File;
/**
 * 创建一个目录
 */
public class MkDriDemo {
    public static void main(String[] args) {
        //在当前项目目录下新建一个目录：demo
//        File dir = new File("./demo");
        File dir = new File("./a/b/c/d/e/f/g");
        if (dir.exists()){
            System.out.println("文件已存在！");
        }else {
            /*
            make:做
            mkdir是linux中的一个命令，用于创建一个目录
         */
//            dir.mkdir();//创建目录时要求该目录所在的目录必须存在，否则创建失败
            dir.mkdirs();//创建目录时会自动将所有不存在的父目录一同创建，推荐使用
            System.out.println("创建完毕！");
        }
    }
}
