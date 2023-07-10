package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) throws Exception{
        Class cls = Class.forName("reflect.Student");

        Object obj1 = cls.newInstance();

        System.out.println(obj1);
        Constructor con = cls.getConstructor(String.class,int.class,char.class);
        Object obj2 = con.newInstance("小聂",22,'男');
        System.out.println(obj2);
    }
}
