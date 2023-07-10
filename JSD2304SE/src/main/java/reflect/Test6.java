package reflect;

import reflect.annotations.AutoRunClass;
import reflect.annotations.AutoRunMethod;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

public class Test6 {
    public static void main(String[] args) throws Exception {
        File dir = new File(Test6.class.getResource(".").toURI());
        String[] fileNames = dir.list();
        String packageName = Test6.class.getPackage().getName();
        for (String fileName : fileNames){
            if (fileName.endsWith(".class")){
                String className = fileName.substring(0,fileName.indexOf("."));
                Class cls = Class.forName(packageName+"."+className);
                if (cls.isAnnotationPresent(AutoRunClass.class)) {
                    Object obj = cls.newInstance();
                    Method[] methods = cls.getMethods();
                    for (Method method : methods){
                        if (method.isAnnotationPresent(AutoRunMethod.class)){
                            System.out.println("正在调用"+className+"类的"+method.getName()+"()方法：");
                            method.invoke(obj);
                        }
                    }
                }
            }
        }
    }
}
