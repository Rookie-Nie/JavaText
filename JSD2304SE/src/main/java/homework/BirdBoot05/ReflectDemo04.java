package homework.BirdBoot05;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectDemo04 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入类名：");
        String className = scanner.nextLine();
        System.out.println("请输入方法名：");
        String methodName = scanner.nextLine();

        Class cls = Class.forName(className);
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(obj);
    }
}
