package file;

import java.io.File;
/*
    将Test中创建的100个文件删除
 */
public class Test2 {
    public static void main(String[] args) {
        for (int i = 1;i<=100;i++){
            File file = new File("./test"+i+".txt");
            file.delete();
        }
        System.out.println("删除完毕！");
    }
}
