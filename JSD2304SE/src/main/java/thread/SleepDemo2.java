package thread;
/**
 * 当一个线程调用sleep方法进入阻塞状态的过程中,此时该线程的interrupt()方法被
 * 调用,那么就会中断该线程的睡眠阻塞,sleep()方法会抛出中断异常
 */
public class SleepDemo2 {
    public static void main(String[] args) {
        Thread lin = new Thread("林永健"){
            @Override
            public void run() {
                System.out.println(getName()+"：刚美完容，睡一会吧。。。。。");
                try {
                    Thread.sleep(100000000);
                } catch (InterruptedException e) {
                    System.out.println(getName()+":干嘛呢！干嘛呢！干嘛呢！都破相了！");
                }
                System.out.println(getName()+":醒了");
            }
        };

        Thread huang = new Thread("黄宏"){
            @Override
            public void run() {
                System.out.println("大锤80，小锤40。开始砸墙！");
                for (int i =0;i<6;i++){
                    System.out.println(getName()+":80!");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("哐当！");
                System.out.println(getName()+":大哥，搞定！");
                lin.interrupt();
            }
        };

        lin.start();
        huang.start();

    }
}
