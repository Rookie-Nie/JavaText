package thread;

public class TreadDemo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for (int i = 0;i<1000;i++){
                    System.out.println("你是谁啊？");
                }
            }
        };

//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0;i<1000;i++){
//                    System.out.println("开门！查水表的！");
//                }
//            }
//        };
        Runnable r2 =() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("开门！查水表的！");
            }
        };
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

    }
}
