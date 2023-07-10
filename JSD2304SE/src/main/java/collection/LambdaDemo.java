package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * Lambda表达式-JDK8之后推出的新特性
 * 语法:
 * (参数列表)->{
 *     方法体
 * }
 *
 * 当使用匿名内部类创建时，如果实现的接口只有一个抽象方法，则可以使用lambda表达
 * 式代替，使代码更简洁优雅。
 *
 * 在java中可以使用lambda表达式代替匿名内部类创建所需要实现的
 * 接口时，该接口上都有一个注解:@FunctionalInterface
 *
 */
public class LambdaDemo {
    public static void main(String[] args) {
        Comparator<String> c1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        };
        //使用lambda表达式
        //lambda表达式就是省去了匿名内部类创建的接口与方法名部分
        Comparator<String> c2 =(String o1, String o2)-> {
                return o1.length()-o2.length();
            };
        //lambda表达式可以忽略参数的类型
        Comparator<String> c3 =(o1, o2)-> o1.length()-o2.length();


        List<String> list = new ArrayList<>();
        list.add("传奇老师");
        list.add("王克晶");
        list.add("刘桑");
        //lambda表达式实际上是编译器认可的，最终会被改回为内部类方式创建
        //源代码中使用lambda可以更突出重点-原匿名内部类 中重写方法的逻辑。
//        Collections.sort(list,(o1, o2) -> o1.length()-o2.length());
        /*
            JDK8之后，List集合自己推出了一个sort方法，可以排序自身元素
            并且需要传入一个比较器来定义比较规则。
         */
        list.sort((o1, o2) -> o1.length()-o2.length());
        System.out.println(list);

    }
}
