package reflect;

import reflect.annotations.AutoRunClass;
import reflect.annotations.AutoRunMethod;

import java.lang.reflect.Method;
/**
 * 反射机制访问注解
 * 所有的反射对象:
 * Class,Method,Field,Constructor,Package...
 * 它们都提供了方法:
 * boolean isAnnotationPresent(Class cls)
 * 用于判断是否被指定的注解标注了
 */
public class ReflectDemo8 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");
        if (cls.isAnnotationPresent(AutoRunClass.class)){
            Method method = cls.getDeclaredMethod("sleep");
            System.out.println(method.getName()+(method.isAnnotationPresent(AutoRunMethod.class)?"()被标注了":"()没有被标注"));
//            if (method.isAnnotationPresent(AutoRunMethod.class)){
//                System.out.println(method.getName()+"()被标注了");
//            }else {
//                System.out.println(method.getName()+"()没有被标注");
//            }
        }else {
            System.out.println(cls.getSimpleName()+"类没有被标注");
        }
    }
}
