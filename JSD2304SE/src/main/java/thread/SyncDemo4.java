package thread;
/**
 * 互斥锁
 *
 * 当使用多个synchronized锁定多个代码片段，并且指定的同步监视器对象相同时
 * 这些代码片段之间就是互斥的
 */
public class SyncDemo4 {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread t1 = new Thread(foo::methodA);
        Thread t2 = new Thread(foo::methodB);

        t1.start();
        t2.start();
    }
}

class Foo{
    public synchronized void methodA(){
        Thread t = Thread.currentThread();
        System.out.println(t.getName()+":正在执行A方法。。。");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getName()+":执行A方法完毕！");

    }
//    public synchronized void methodB(){
    public void methodB(){
        synchronized (this) {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + ":正在执行B方法。。。");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.getName() + ":执行B方法完毕！");
        }
    }
}
