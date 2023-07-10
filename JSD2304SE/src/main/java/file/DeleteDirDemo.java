package file;

import java.io.File;

/*
    删除一个目录
 */
public class DeleteDirDemo {
    public static void main(String[] args) {
        File dir = new File("./demo");
        /*
            delete方法在删除目录时要求必须是空目录，否则删除失败
         */
        dir.delete();
        System.out.println("目录已删除！");
    }
}
