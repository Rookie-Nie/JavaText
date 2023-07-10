package reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectDemo5 {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        p.say("你好！");

        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();

        Method method1 = cls.getMethod("say",String.class);
        method1.invoke(obj,"大家好！");

        Method method2 = cls.getMethod("say",String.class,int.class);
        method2.invoke(obj,"嘿嘿嘿！",5);

        int modifier = method1.getModifiers();
        switch (modifier){
            case Modifier.PUBLIC:
                System.out.println("公开方法！");
                break;
            case Modifier.PRIVATE:
                System.out.println("私有方法！");
                break;
        }

        int count = method2.getParameterCount();
        System.out.println(method2.getName()+"方法有"+count+"个参数");
    }
}
