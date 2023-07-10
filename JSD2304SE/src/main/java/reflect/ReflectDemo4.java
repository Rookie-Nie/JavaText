package reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        Person per = new Person();
        per.sayHello();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入类名：");
        String className = scanner.nextLine();
        System.out.println("请输入方法名：");
        String methodName = scanner.nextLine();

        Class cls = Class.forName(className);
        Object p = cls.newInstance();

        Method method = cls.getMethod(methodName);
        method.invoke(p);//p.sayHello
    }
}
