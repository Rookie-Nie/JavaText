package homework.BirdBoot05;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URISyntaxException;

public class Test4 {
    public static void main(String[] args) throws Exception {
        File dir = new File(Test4.class.getResource(".").toURI());
        String[] fileName = dir.list();
        String packageName = Test4.class.getPackage().getName();
        for (String classname : fileName){
            if (classname.endsWith(".class")){
                Class cls = Class.forName(packageName+"."+classname.substring(0,classname.indexOf(".")));
                Object obj = cls.newInstance();
                System.out.println(obj);
                Method[] methods = cls.getMethods();
                for (Method method : methods){
                    if (method.getModifiers() == Modifier.PUBLIC && method.getParameterCount() == 0){
                        method.invoke(obj);
                    }
                }
            }
        }
    }
}
