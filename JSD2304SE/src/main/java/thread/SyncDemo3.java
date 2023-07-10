package thread;

/**
 * 静态方法上使用synchronized时，该方法一定具有同步效果
 *
 * 静态方法上锁对象不可选的，默认为当前类的类对象(Class类的实例)
 * Class类:它的每一个实例被称为类对象。
 * JVM加载一个类时，就会同时实例化一个Class的实例并保存加载类的信息，而且该
 * Class的实例对于每个被加载的类都有且只有一个实例对应。
 *
 * Class具体的知识会在后续反射机制中被介绍
 *
 */
public class SyncDemo3 {
    public static void main(String[] args) {
        Boo b1 = new Boo();
        Boo b2 = new Boo();
        Thread t1 = new Thread(){
            @Override
            public void run() {
//                Boo.dosome();
                b1.dosome();
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
//                Boo.dosome();
                b2.dosome();
            }
        };

        t1.start();
        t2.start();
    }
}

class Boo{
//    public static synchronized void dosome(){
    public static void dosome(){
        //在静态方法中使用同步块时，也使用类对象作为同步监视器对象
        synchronized (Boo.class){
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+":正在执行dosome方法。。。");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.getName()+":正在执行dosome方法。。。");
        }
    }
}
