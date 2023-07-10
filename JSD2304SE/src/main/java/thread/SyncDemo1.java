package thread;

import java.util.concurrent.ThreadLocalRandom;
/**
 * 多线程并发的安全问题
 * 当多个线程并发操作同一临界资源，由于线程切换实际不确定，会导致操作顺序未按照
 * 程序设计过程执行，导致操作出现混乱，从而产生不良后果。
 *
 * 临界资源:操作该资源的完整步骤同一时刻只能由单一一个线程进行。
 */
public class SyncDemo1 {
    public static void main(String[] args) {
        Table table = new Table();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true) {
                    int bean = table.getBeans();
                    Thread.yield();
                    System.out.println(getName()+":"+bean);
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true) {
                    int bean = table.getBeans();
                    Thread.yield();
                    System.out.println(getName()+":"+bean);
                }
            }
        };

        t1.start();
        t2.start();
    }
}

class Table{
    private int beans = 20;

    public synchronized int getBeans(){
        if (beans == 0){
            throw new RuntimeException("没有豆子了！");
        }
        Thread.yield();
        return beans--;
    }
}
