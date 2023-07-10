package reflect;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URISyntaxException;

public class Test4 {
    public static void main(String[] args) throws Exception {
        File dir = new File(Test4.class.getResource(".").toURI());
        String[] classNames = dir.list();
        String packageName = Test4.class.getPackage().getName();
        for (String className : classNames){
            if (className.endsWith(".class")){
                Class cls = Class.forName(packageName+"."+className.substring(0,className.indexOf(".")));
                Object obj = cls.newInstance();
                System.out.println(obj);
                Method[] methods = cls.getMethods();
                for (Method method : methods){
                    if (method.getModifiers() == Modifier.PUBLIC && method.getParameterCount() == 0){
                        System.out.println("正在调用"+className+"的"+method.getName()+"方法");
                        method.invoke(obj);
                    }
                }
            }
        }

    }

}
