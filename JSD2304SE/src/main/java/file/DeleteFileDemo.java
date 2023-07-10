package file;

import java.io.File;

public class DeleteFileDemo {
    public static void main(String[] args) {
        //将当前目录下的text.txt文件删除
        File file = new File("./test1.txt");
        /*
            boolean delete()
            当且仅当File表示的文件或目录被成功删除返回true
         */
        boolean delete = file.delete();
        System.out.println("删除"+(delete ? "成功":"失败"));
    }
}
