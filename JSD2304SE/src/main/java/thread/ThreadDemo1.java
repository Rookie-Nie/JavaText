package thread;
/**
 * Thread类  线程
 * Thread允许我们在java程序中"同时"执行多段代码
 * 实际上CPU在执行代码时会快速在这些线程之间切换执行，造成一种感官错觉是这些
 * 线程中的代码在"同时"执行，这种执行现象成为"并发运行"
 *
 * 创建线程的常见方式之一:
 * 1:继承Thread类
 * 2:重写run方法
 *   在run方法中定义该线程需要的代码
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread t1 = new MyThread1();
        Thread t2 = new MyThread2();

        t1.start();
        t2.start();

    }
}

/**
 * 第一种创建线程的方式
 * 优点:结构简单，利于匿名内部类方式创建
 * 缺点:
 * 1:java是单继承的，这意味着如果继承了Thread就无法再继承其他类去复用方法
 * 2:继承Thread的同时将任务定义在线程中，会导致线程与任务存在必然的耦合关系
 *   不利于线程的重用
 */
class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0;i < 1000 ;i++){
            System.out.println("你是谁啊？");
        }
    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0;i < 1000 ;i++){
            System.out.println("开门！查水表的！");
        }
    }
}
