package thread;
/**
 * 获取线程相关信息的一组方法
 */
public class ThreadInfoDemo {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();

        String name = main.getName();
        System.out.println("线程的名字："+name);

        int priority = main.getPriority();
        System.out.println("优先级："+priority);

        long id = main.getId();
        System.out.println("id："+id);

        boolean daemon = main.isDaemon();
        System.out.println("是否为守护线程："+daemon);

        boolean alive = main.isAlive();
        System.out.println("是否活着："+alive);

        boolean interrupted = main.isInterrupted();
        System.out.println("是否被中断："+interrupted);

    }
}
