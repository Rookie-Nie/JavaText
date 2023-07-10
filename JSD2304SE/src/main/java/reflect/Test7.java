package reflect;

import reflect.annotations.AutoRunClass;
import reflect.annotations.AutoRunMethod;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

public class Test7 {
    public static void main(String[] args) throws Exception {
        File dir = new File(Test7.class.getResource(".").toURI());
        String[] fileNames = dir.list();
        String packageName = Test7.class.getPackage().getName();
        for (String fileName : fileNames){
            if (fileName.endsWith(".class")){
                String className = fileName.substring(0,fileName.indexOf("."));
                Class cls = Class.forName(packageName + "." + className);
                if (cls.isAnnotationPresent(AutoRunClass.class)){
                    Object obj = cls.newInstance();
                    Method[] methods = cls.getMethods();
                    for (Method method : methods){
                        if (method.isAnnotationPresent(AutoRunMethod.class)){
                            AutoRunMethod arm = method.getAnnotation(AutoRunMethod.class);
                            int value = arm.value();
                            System.out.println("开始调用"+className+"中的"+method.getName()+"()方法"+value+"次");
                            for (int i = 0;i<value;i++){
                                method.invoke(obj);
                            }
                        }
                    }
                }
            }
        }
    }
}
