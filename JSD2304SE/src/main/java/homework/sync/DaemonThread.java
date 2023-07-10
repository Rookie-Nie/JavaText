package homework.sync;

public class DaemonThread {
    public static void main(String[] args) {
        Thread rose = new Thread("rose"){
            @Override
            public void run() {
                for (int i = 0;i<4;i++){
                    System.out.println(getName()+":let me die...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(getName()+":啊啊啊啊啊啊啊啊啊啊啊啊啊aaaaaaaaa");
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

        jack.setDaemon(true);
        jack.start();
        rose.start();
    }
}
