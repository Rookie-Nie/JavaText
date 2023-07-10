package thread;
/**
 * 守护线程
 *
 * 守护线程是通过用户线程(普通线程,线程创建出来默认就是用户线程)调用方法:
 * setDaemon(true)设置而来的.
 *
 * 守护线程与用户线程的主要区别是进程结束:
 * 当java进程中所有的用户线程都结束时,该进程就会结束,此时在进程结束前会强行杀死
 * 所有还在运行的守护线程
 *
 * GC就是运行在守护线程上的。
 * 当一个任务需要单独并发执行，但是该任务何时停止没有确切时间，只要我们主要的
 * 工作都执行完毕它可以跟着结束时，那么该任务就非常适合放在守护线程上执行了。
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread rose = new Thread("rose"){
            @Override
            public void run() {
                for (int i =0;i<4;i++){
                    System.out.println(getName()+":let me die!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(getName()+":啊啊啊啊啊啊啊啊啊aaaaaaaaaaa");
                System.out.println("pia!");
            }
        };

        Thread jack = new Thread("jack"){
            @Override
            public void run() {
                while (true){
                    System.out.println(getName()+":you jump,i jump!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        ///设置守护线程必须在该线程启动前进行
        jack.setDaemon(true);
        jack.start();
        rose.start();

        while (true);
    }
}
