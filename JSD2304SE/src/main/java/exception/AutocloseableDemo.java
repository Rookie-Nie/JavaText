package exception;

import java.io.FileOutputStream;
import java.io.IOException;
/**
 * JDK7之后,java推出了一个新的特性:自动关闭特性
 * 可以在异常处理机制中更优雅的关闭流这类需要调用close关闭的类
 *
 */
public class AutocloseableDemo {
    public static void main(String[] args) {
        try (
//          try()中可以定义最终要在finally中调用close的那些类
//          实际上只有实现了java.io.AutoCloseable接口的类才可以在这里定义
//          java中所有的流都实现了AutoCloseable接口
//          该特性是编译器认可的,最终在try()中定义的类会在finally中被调用close关闭,相当于FinallyDemo2的样子
                FileOutputStream fos = new FileOutputStream("fos.dat");
        ){
            fos.write(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
