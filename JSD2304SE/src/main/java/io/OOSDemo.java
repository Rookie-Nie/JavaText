package io;

import string.TrimDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/**
 * 对象流
 * java.io.ObjectOutputStream和ObjectInputStream
 * 对象流是一对高级流,在流连接中的作用是进行对象的序列化与反序列化
 *
 * 对象序列化:将一个java对象转换为一组可以被保存或传输的字节的过程
 *
 */
public class OOSDemo {
    public static void main(String[] args) throws IOException {
        String name = "王克晶";
        int age = 18;
        String gender = "女";
        String[] otherInfo = {"嗓门大","黑","技术好","贤妻良母"};
        Person p = new Person(name,age,gender,otherInfo);
        System.out.println(p);
        FileOutputStream fos = new FileOutputStream("person.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
         /*
            对象输出流提供的方法:
            void writeObject(Object obj)
            可以将给定对象进行序列化,前提,该对象所属的类必须实现接口:
            java.io.Serializable
            否则序列化时会抛出异常:java.io.NotSerializableException
         */
        oos.writeObject(p);
        System.out.println("写出完毕");
        oos.close();
    }
}
