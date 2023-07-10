package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FISDemo {
    public static void main(String[] args) throws IOException {
        //将fos.dat文件中的字节读取出来
        FileInputStream fis = new FileInputStream("./test.txt");
        /*
            InputStream的超类中定义了读取一个字节的方法
            int read()
            通过流读取1个字节到程序中,返回的int值对应的2进制"低八位"有效.
            如果返回的int值直接表示整数-1,则表示流读取到了末尾EOF
            EOF:end of file

---------------------------------------------------------------------
            fos.dat内容:
            00000001 00000010
---------------------------------------------------------------------
            第一次调用:
            int d = fis.read()

            fos.dat内容:
            00000001 00000010
            ^^^^^^^^
            读取的字节

            读取后变量d的2进制样子:
            00000000 00000000 00000000 00000001
            |---------补充24个0-------| ^^^^^^^^
                                       读取到的数据
         */
        /*
            11111111 00000010
            ^^^^^^^^

            00000000 00000000 00000000 11111111   255
            |---------补充24个0-------| ^^^^^^^^


         */
        int d = fis.read();
        System.out.println(d);//1
        /*
            第二次调用:
            d = fis.read()

            fos.dat内容:
            00000001 00000010
                     ^^^^^^^^
                     读取的字节

            读取后变量d的2进制样子:
            00000000 00000000 00000000 00000010
            |---------补充24个0-------| ^^^^^^^^
                                       读取到的数据
         */
        d = fis.read();
        System.out.println(d);//2
        /*
            第三次调用:
            d = fis.read()

            fos.dat内容:
            00000001 00000010
                               ^^^^^^^^
                               文件末尾

            读取后变量d的2进制样子:
            11111111 11111111 11111111 11111111
            |------------补充32个1-------------|

         */
        d = fis.read();//-1
        System.out.println(d);

        System.out.println("读取完毕");
        fis.close();
    }
}
