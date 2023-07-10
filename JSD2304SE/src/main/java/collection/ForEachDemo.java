package collection;

import java.util.ArrayList;
import java.util.Collection;
/**
 * JDK8之后，java在集合Collection接口中添加了一个用于遍历集合元素的forEach
 * 方法。可以基于lambda表达式遍历集合元素。
 */
public class ForEachDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        //新循环方式（迭代器方式）
        for (String e : c){
            System.out.println(e);
        }
        //tips：当lambda中只有一个参数时，参数列表的“（）”可以忽略不写
        c.forEach(e -> System.out.println(e));
        /*
            JDK8中出现的lambda表达式的变种写法:方法引用
            对象::方法
            当lambda表达式的参数与方法体中调用方法的参数一致时
            例如:
            (e)->System.out.println(e);
            那么就可以写作:
            System.out::println;
                  对象::方法
            现在以了解为主即可
         */

        c.forEach(System.out::println);

    }
}
