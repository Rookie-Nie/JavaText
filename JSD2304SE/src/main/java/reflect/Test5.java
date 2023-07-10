package reflect;

import reflect.annotations.AutoRunClass;

import java.io.File;
import java.net.URISyntaxException;

public class Test5 {
    public static void main(String[] args) throws Exception {
        File dir = new File(Test5.class.getResource(".").toURI());
        String[] fileName = dir.list();
        String packageName = Test5.class.getPackage().getName();
        for (String className : fileName){
            if (className.endsWith(".class")){
                Class cls =Class.forName(packageName+"."+className.substring(0,className.indexOf(".")));
                if (cls.isAnnotationPresent(AutoRunClass.class)){
                    Object obj = cls.newInstance();
                    System.out.println(obj);
                }
            }
        }
    }
}
