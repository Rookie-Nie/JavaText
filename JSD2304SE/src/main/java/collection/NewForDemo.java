package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * JDK5之后，java推出了一个新的特性:增强型for循环，也成为了新循环
 * 新循环不取代传统for循环的工作，【它只用来遍历集合或数组】
 * 语法:
 * for(元素类型 变量名 : 数组或集合){
 *     循环体...
 * }
 *
 *
 * JDK5推出的另一个新特性:泛型
 * 泛型又称为参数化类型，是当我们使用一个类时，可以去指定该类中某个属性或者方法的
 * 参数或者方法的返回值的类型。使得我们使用该类更灵活。
 * 泛型在集合中应用十分广泛，用于规定集合中的元素类型。
 *
 */

public class NewForDemo {
    public static void main(String[] args) {
        String[] arr = {"one","two","three","four","five","six"};
        for (int i = 0;i<arr.length;i++){
            String e = arr[i];
            System.out.println(e);
        }
        System.out.println("--------------------");
        /*
            新循环是编译器认可的，在编译时会将其改为传统for循环遍历数组
         */
        for (String e : arr){
            System.out.println(e);
        }

        System.out.println("--------------------");
        //泛型在使用时可以指定确定类型，若不能指定则为默认原型：obje
        Collection<String> c= new ArrayList();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        c.add("six");
        //c.add(123);//编译不通过，add(E e)在这里E被当做String类型。
        for (Object e : c){
            String s = (String) e;
            System.out.println(s);
        }
        //迭代器也支持泛型，定义时与其遍历的集合指定的泛型一致即可。
        Iterator<String> it = c.iterator();
        while (it.hasNext()){
            String s = it.next();       //获取元素时不需要再造型
            System.out.println(s);
        }
    }
}
