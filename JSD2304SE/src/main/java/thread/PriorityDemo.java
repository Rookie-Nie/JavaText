package thread;
/**
 * 线程的优先级
 * 线程有10个优先级,分别用整数1-10表示
 * 其中1为最低优先级,5为默认优先级,10为最高优先级
 *
 * 线程提供的方法:
 * void setPriority(int priority)
 * 设置线程的优先级
 *
 * 当我们调用一个线程start方法后该线程就会纳入到线程调度器中被统一管理.此时
 * 线程只能被动的被分配时间片并发执行.线程不能主动索取时间片.
 * 调整线程的优先级可以最大程度的改善获取时间片的概率,优先级高的线程获取时间片
 * 的次数多.
 */
public class PriorityDemo {
    public static void main(String[] args) {
        Thread min = new Thread(){
            @Override
            public void run() {
                for (int i = 0;i<100;i++){
                    System.out.println("min");
                }
            }
        };

        Thread max = new Thread(){
            @Override
            public void run() {
                for (int i = 0;i<100;i++){
                    System.out.println("max");
                }
            }
        };

        Thread norm = new Thread(){
            @Override
            public void run() {
                for (int i = 0;i<100;i++){
                    System.out.println("norm");
                }
            }
        };

        min.setPriority(Thread.MIN_PRIORITY);
        norm.setPriority(Thread.NORM_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);

        min.start();
        norm.start();
        max.start();
    }
}




