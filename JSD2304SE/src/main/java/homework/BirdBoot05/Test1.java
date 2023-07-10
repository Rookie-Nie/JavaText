package homework.BirdBoot05;

import java.lang.reflect.Constructor;

public class Test1 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("homework.BirdBoot05.Person");
        Object obj1 = cls.newInstance();
        System.out.println(obj1);

        Constructor con = cls.getConstructor(String.class,int.class,char.class);
        Object obj2 = con.newInstance("小聂",18,'男');
        System.out.println(obj2);
    }
}
