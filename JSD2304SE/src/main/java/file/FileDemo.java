package file;

import java.io.File;
/**
 * java.io.File
 * File类的每一个实例用于表示文件系统中的一个文件或目录(本质是保存一个路径)
 * 使用File我们可以:
 * 1:访问文件或目录的属性(名字，大小等信息)
 * 2:创建/删除 文件或目录
 * 3:访问一个目录中的所有子项
 *
 * 但是不能访问文件数据
 */
public class FileDemo {
    public static void main(String[] args) {
        //       实际开发中，我们不会使用绝对路径:因为存在跨平台问题
//        File file = new File("D:/Java/JSD2304SE/demo.txt");
//       相对路径中"./"表示当前目录，在IDEA中是当前项目目录
        File file = new File("./demo.txt");
        String name = file.getName();
        System.out.println("文件名："+name);
        /*
            long length
            返回当前File表示的文件的长度(单位是字节)
         */
        long len = file.length();
        System.out.println("文件大小："+len);

        //是否可读
        boolean cr = file.canRead();
        System.out.println("是否可读："+cr);
        //是否可写
        boolean cw = file.canWrite();
        System.out.println("是否可写："+cw);
        //是否隐藏
        boolean hidden = file.isHidden();
        System.out.println("是否隐藏："+hidden);
    }
}
