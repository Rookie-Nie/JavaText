package reflect;

import reflect.annotations.AutoRunClass;

public class ReflectDemo7 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("reflect.Person");
        boolean mark = cls.isAnnotationPresent(AutoRunClass.class);
        if (mark){
            System.out.println(cls.getSimpleName()+"被标注了");
        }else {
            System.out.println(cls.getSimpleName()+"没有被标注");
        }
    }
}
