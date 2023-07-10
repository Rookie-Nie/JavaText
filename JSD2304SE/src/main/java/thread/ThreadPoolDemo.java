package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        //创建一个线程池
        //创建一个固定大小的线程池，容量为2
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        for (int i = 0;i<5;i++){
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread t = Thread.currentThread();
                        System.out.println(t+"：正在执行任务。。。");
                        Thread.sleep(5000);
                        System.out.println(t+"：执行任务完毕。。。");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };


            threadPool.execute(r);//将任务交给线程池去执行
            System.out.println("将一个任务交给了线程池");
        }
        //关闭线程池，线程池不再接受新任务，等线程池中所有任务都执行后结束
        threadPool.shutdown();
        //立即关闭线程池
        threadPool.shutdownNow();
        System.out.println("线程池关闭了");

    }
}
