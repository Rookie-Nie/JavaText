package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
/**
 * java将流按照读写的数据单位划分为字节与字符流
 * java.io.InputStream和OutputStream是字节流的超类
 * java.io.Reader和Writer是字符流的超类
 *
 * 字符流的最小读写单位是一个char(字符)
 * 字符流都是高级流，本质上底层最后还是要读写字节，只不过字符与字节的转换由字符
 * 流完成
 *
 *
 * 转换流
 * 转换流是字符流常用的一对实现类
 * 他们在流链接中是重要的一环，但是实际开发中我们不会直接操作这对流
 * java.io.InputStreamReader和OutputStreamWriter
 *
 * 转换流是唯一一对可以链接在字节流上的字符流，这样以来其他的字符流就可以通过
 * 链接转换流最终和字节流搭配使用
 *
 */
public class OSWDemo {
    public static void main(String[] args) throws IOException {
        //向文件osw.txt中写入文本数据
        FileOutputStream fos = new FileOutputStream("osw.txt");
        /*
            转换流的主要工作之一就是将写出的字符按照指定的字符集转换为字节
            因此，构造器创建时除了指明连接在哪个流上之外，还可以明确字符集
         */
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        //字符流可以直接写出字符串
        osw.write("大雾四起，我在大雾中爱你！");
        osw.write("大雾散尽，我爱你人尽皆知！");
        System.out.println("写出完毕！");
        osw.close();
    }
}
