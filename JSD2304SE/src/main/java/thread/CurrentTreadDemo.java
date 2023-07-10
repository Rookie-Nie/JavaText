package thread;

public class CurrentTreadDemo {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();//在main方法中可以用来获取主线程
        System.out.println("执行main方法的线程是："+main);

        dosome();
    }

    public static void dosome(){
        Thread t = Thread.currentThread();
        System.out.println("运行dosome方法的线程是："+t);
    }
}
