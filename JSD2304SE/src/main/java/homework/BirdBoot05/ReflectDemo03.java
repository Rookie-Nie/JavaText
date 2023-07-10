package homework.BirdBoot05;

import java.lang.reflect.Constructor;

public class ReflectDemo03 {
    public static void main(String[] args) throws Exception {
        Person p = new Person("聂某",22,'男');
        System.out.println(p);

        Class cls = Class.forName("homework.BirdBoot05.Person");
        Constructor con = cls.getConstructor(String.class,int.class,char.class);
        Object obj = con.newInstance("小聂",18,'男');
        System.out.println(obj);
    }
}
