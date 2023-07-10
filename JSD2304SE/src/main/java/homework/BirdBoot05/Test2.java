package homework.BirdBoot05;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test2 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("homework.BirdBoot05.Person");
        Object obj = cls.newInstance();

        Method[] methods = cls.getMethods();
        for (Method method : methods){
            if (method.getModifiers() == Modifier.PUBLIC && method.getParameterCount() == 0 && method.getName().startsWith("s")){
                System.out.println("正在执行"+method.getName());
                method.invoke(obj);
            }
        }
    }
}
