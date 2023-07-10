package thread;
/**
 * 第二种创建线程的方式:
 * 实现Runnable接口单独定义线程任务
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        //1实例化任务
        Runnable r1 = new MyRunnable1();
        Runnable r2 = new MyRunnable2();
        //2实例化线程并指派任务
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        //3启动线程
        t1.start();
        t2.start();
    }
}
/*
    第二种创建方式优点:
    1:没有继承冲突问题
    2:与线程没有必然耦合关系

    缺点:
    创建上会麻烦一些
 */
class MyRunnable1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i<1000 ;i++){
            System.out.println("你是谁啊？");
        }
    }
}
class MyRunnable2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i<1000 ;i++){
            System.out.println("开门！查水表的！");
        }
    }
}

