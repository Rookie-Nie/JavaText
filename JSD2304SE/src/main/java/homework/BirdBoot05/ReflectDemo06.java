package homework.BirdBoot05;

import homework.BirdBoot05.demo.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectDemo06 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("homework.BirdBoot05.Person");
        Object obj = cls.newInstance();
        Method method = cls.getDeclaredMethod("haha");
        method.setAccessible(true);
        method.invoke(obj);
        method.setAccessible(false);

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1);
        System.out.println(s2);

        Class c = Class.forName("homework.BirdBoot05.demo.Singleton");
        Constructor con = c.getDeclaredConstructor();
        con.setAccessible(true);
        Object o = con.newInstance();
        System.out.println(o);
        con.setAccessible(false);
    }
}
