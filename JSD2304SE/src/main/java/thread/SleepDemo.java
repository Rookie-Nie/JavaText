package thread;

import java.util.Scanner;

/**
 * Thread提供了主动阻塞的方法:
 * static void sleep(long ms)
 * 允许当前线程主动进入阻塞状态指定毫秒,超时后线程会自动回到RUNNABLE状态再次开始
 * 并发操作
 */
public class SleepDemo {
    public static void main(String[] args) {
//        System.out.println("程序开始了");
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("程序结束了");


        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个倒计时数：");
        for (int num = scanner.nextInt() ; num > 0; num--){
            System.out.println(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("时间到！");
    }
}
