package reflect;

import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) throws Exception {
        File dir = new File(Test3.class.getResource(".").toURI());
        String[] name = dir.list();
        String pName = Test3.class.getPackage().getName();
        for (String className : name){
            if (className.endsWith(".class")) {
                Class cls = Class.forName(pName+"."+className.substring(0,className.indexOf(".")));
                Constructor con = cls.getDeclaredConstructor();
                con.setAccessible(true);
                Object obj = con.newInstance();
                System.out.println(obj);
                con.setAccessible(false);
//            Object obj = cls.newInstance();
//            System.out.println(obj);
            }
        }
    }
}
