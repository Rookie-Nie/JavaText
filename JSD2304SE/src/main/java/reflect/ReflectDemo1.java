package reflect;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Scanner;

/**
 * JAVA的反射机制
 * 反射机制是java的动态机制，允许我们在程序【运行期间】再确定对象的实例化，方法的调用
 * 属性的操作等。
 * 反射机制大大的提高了代码的灵活度和可扩展性，但是也存在较慢的运行效率，和较多的资源开销。
 * 因此反射机制不能被过度的使用。
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
                反射机制第一步:获取类对象 Class的实例
                Class类的每一个实例用于表示一个类，所以我们也称它为"类对象"
                在JVM内部，每个被加载的类都有且只有一个Class的实例与之对应，通过
                这个类对象可以得知其表示的类的一切信息:包信息，类名，构造器，方法，属性等

                反射操作的第一件事就是获取要操作的类的类对象
                获取一个类的类对象方式:
                1:类名.class
                Class cls = String.class;
                Class cls = int.class;//基本类型获取它对应的类对象方式只有这一种

                2:Class.forName(String className)
                通过指定类的完全限定名(包名.类名)来加载并获取该类的类对象
                Class cls = Class.forName("java.lang.String");

                3:ClassLoader获取类对象
             */
        //获取String的类对象
//        Class cls = String.class;//该cls对象表示的就是String类的信息
//        Class cls = HashMap.class;
        //使用Class.forName()加载类对象
//        Class cls = Class.forName("java.util.ArrayList");

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入类名：");
        String className = scanner.nextLine();
        Class cls = Class.forName(className);

        //获取类对象所表示的类的完全限定名
        String name = cls.getName();
        System.out.println(name);
        //仅获取类名
        name = cls.getSimpleName();
        System.out.println(name);
        //获取包信息
        Package p = cls.getPackage();
        String pname = p.getName();
        System.out.println(pname);
         /*
            Class的getMethods()方法可以获取其表示的类的所有【公开】方法，包含从
            超类继承下来的

            Method类:方法对象，该类的每一个实例用于表示一个方法
            通过方法对象我们可以:
            获取该方法的信息(方法名，返回值类型，参数类型，参数个数等)
            还可以调用该方法
         */

        Method[] methods = cls.getMethods();
        for (Method method : methods){
            String mname = method.getName();//通过方法对象获取该方法的名字
            System.out.println(mname);
        }
    }
}
