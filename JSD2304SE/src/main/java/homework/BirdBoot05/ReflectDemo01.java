package homework.BirdBoot05;

import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectDemo01 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入类名：");
        String className = scanner.nextLine();
        Class cls = Class.forName(className);

        String name = cls.getName();
        System.out.println("该类的相对路径为："+name);

        name = cls.getSimpleName();
        System.out.println("该类名为："+name);

        Package p = cls.getPackage();
        System.out.println("该类所在包为："+p.getName());

        Method[] methods = cls.getMethods();
        System.out.println("该类包含的方法有:");
        for ( Method method : methods){
            System.out.println(method.getName());
        }
    }
}
