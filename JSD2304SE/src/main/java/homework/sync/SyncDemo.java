package homework.sync;

public class SyncDemo {
    public static void main(String[] args) {
        /*Shop shop = new Shop();
        Thread t1 = new Thread("王克晶"){
            @Override
            public void run() {
                shop.buy();
            }
        };

        Thread t2 = new Thread("范传奇"){
            @Override
            public void run() {
                shop.buy();
            }
        };*/

        /*Boo boo = new Boo();
        Thread t1 = new Thread(Boo::dosome);
        Thread t2 = new Thread(Boo::dosome);*/

        Foo foo = new Foo();
        Thread t1 = new Thread(foo::methodA);
        Thread t2 = new Thread(foo::methodB);


        t1.start();
        t2.start();
    }
}

class Shop{
    public void buy(){
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+":正在挑衣服。。。");
            Thread.sleep(3000);

            synchronized (this) {
                System.out.println(t.getName() + ":正在试衣服。。。");
                Thread.sleep(5000);
            }

            System.out.println(t.getName()+":结账离开！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Boo{
    public static void dosome() {
        synchronized (Boo.class) {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + ":正在执行dosome方法。。。");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.getName() + ":执行dosome方法结束！");
        }
    }
}

class Foo{
    public synchronized void methodA(){
        Thread t = Thread.currentThread();
        System.out.println(t.getName()+":正在执行A方法。。。");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getName()+":A方法执行完毕！");
    }

    public synchronized void methodB(){
        Thread t = Thread.currentThread();
        System.out.println(t.getName()+":正在执行B方法。。。");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getName()+":B方法执行完毕！");
    }
}
