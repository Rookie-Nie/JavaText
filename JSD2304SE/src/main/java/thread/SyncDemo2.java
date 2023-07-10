package thread;

import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;
/**
 * 同步块
 * 有效的缩小同步范围可以在保证并发安全的前提下提高并发效率
 * 语法:
 * synchronized(同步监视器对象){
 *     需要同步执行的代码片段
 * }
 */
public class SyncDemo2 {
    public static void main(String[] args) {
//        Shop shop = new Shop();
        Shop shop1 = new Shop();
        Shop shop2 = new Shop();
        Thread t1 = new Thread("范传奇"){
            @Override
            public void run() {
                shop1.buy();
            }
        };

        Thread t2 = new Thread("王克晶"){
            @Override
            public void run() {
                shop2.buy();
            }
        };

        t1.start();
        t2.start();


    }
}

class Shop{
//    public synchronized void buy(){
    public void buy(){
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+":正在挑衣服。。。");
            Thread.sleep(5000);

            /*
                使用同步块可以更准确的锁定需要多个线程同步执行的代码片段
                这里使用时要指定同步监视器对象，"()"中的内容。
                它的要求:
                1:必须是一个引用类型的实例
                2:多个需要同步执行该同步块的线程看到的必须是同一个对象
                合适的锁对象:
                应当是当多个线程存在"抢"的问题时才限制他们必须排队进行，
                不存在"抢"的问题时可以同时进行。
             */
            synchronized (this){
//            synchronized (new Object()){//new一定无效
            System.out.println(t.getName()+":正在试衣服。。。");
            Thread.sleep(5000);
            }

            System.out.println("结账离开。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
