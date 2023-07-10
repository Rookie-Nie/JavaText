package reflect;

import reflect.annotations.AutoRunMethod;

import java.lang.reflect.Method;

public class ReflectDemo9 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");
        Method method = cls.getDeclaredMethod("playGame");
        if (method.isAnnotationPresent(AutoRunMethod.class)){
            AutoRunMethod arm = method.getAnnotation(AutoRunMethod.class);
            int value = arm.value();
            System.out.println("参数值为："+value);
        }
    }
}
