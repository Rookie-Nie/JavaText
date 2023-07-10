package collection;

import java.util.ArrayList;
import java.util.List;
/**
 * List重载了一对add,remove方法
 */
public class ListDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        /*
            void add(int index,E e)
            将给定元素插入到集合指定位置
            [one, two, six, three, four, five]
         */
        list.add(2,"six");
        System.out.println(list);

        /*
            E remove(int index)
            删除并返回指定位置上的元素

            [one, two, six, four, five]
         */
        String old = list.remove(3);
        System.out.println(list);
        System.out.println("被删除的元素是："+old);
    }
}
