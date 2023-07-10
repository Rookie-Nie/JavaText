package homework.BirdBoot05;

import java.util.Scanner;

public class ReflectDemo02 {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        System.out.println(p);

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入类名：");
        String className = scanner.nextLine();
        Class cls = Class.forName(className);
        Object obj = cls.newInstance();
        System.out.println(obj);
    }
}
