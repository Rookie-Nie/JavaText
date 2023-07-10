package homework.thread;

public class ThreadDemo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0;i<1000;i++){
                    System.out.println("你是谁啊？");
                }
            }
        };

        /*Runnable r1 = new Runnable() {//匿名内部类写法
            @Override
            public void run() {
                for (int i = 0;i<1000;i++){
                    System.out.println("开门！查水表的！");
                }
            }
        };*/
        Runnable r1 = ()->{//lambda表达式写法
            for (int i = 0;i<1000;i++){
                System.out.println("开门！查水表的！");
            }
        };
        Thread t2 = new Thread(r1);

        t1.start();
        t2.start();

    }
}
