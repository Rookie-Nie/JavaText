package reflect;

import reflect.demo.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectDemo6 {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
//        p.hehe();//编译不通过，类的外部不可以访问类的私有成员
        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();

//        Method method = cls.getMethod("hehe");
        Method method = cls.getDeclaredMethod("hehe");
        method.setAccessible(true);
        method.invoke(obj);
        method.setAccessible(false);

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1);
        System.out.println(s2);

        Class cls1 = Class.forName("reflect.demo.Singleton");
        Constructor con = cls1.getDeclaredConstructor();
        con.setAccessible(true);
        Object s3 = con.newInstance();
        System.out.println(s3);
        con.setAccessible(false);
    }
}
