package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * java.util.List接口
 * List继承自Collection。
 * List的特点:有序且可以重复。List行业里称为:线性表
 * List常用的实现类:
 * java.util.ArrayList:内部使用数组实现，特点:查询性能好，增删元素性能弱
 * java.util.LinkedList:内部使用链表实现，特点:首尾增删元素性能好，查询性能弱
 *
 * List接口中定义了一套可以通过下标操作元素的方法
 *
 */
public class ListDmeo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        /*
            E get(int index)
            获取List集合中指定下标处对应的元素
         */
        String e = list.get(3); //获取第四个元素
        System.out.println(e);

        for (int i = 0;i< list.size();i++){
            e = list.get(i);
            System.out.println(e);
        }
        /*
            E set(int index, E e)
            将给定元素e设置到指定下标index处，返回值为被替换的元素
            该方法是替换元素操作
         */
        String old = list.set(2,"six");
        System.out.println(list);
        System.out.println("被替换的元素："+old);
        /*
            集合元素反转
            两两交换。第一个和最后一个换，第二个和倒数第二个换。。。
            下标的计算可以参考曾经的回文案例
            [one, six, three, two, one]
              0    1          3    4

         */
        /*for (int i =0;i< list.size()/2;i++){
            list.set(list.size()-1-i,list.set(i, list.get(list.size()-1-i)));
        }*/
        Collections.reverse(list);
        System.out.println(list);
    }
}
