package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * java集合框架
 * java.util.Collection接口，是所有集合的顶级接口，规定了集合所必须的功能
 *
 * 集合与数组一样，可以保存一组具有相同类型元素数据结构
 * 并且提供了对于元素的维护操作(方法)。
 * 集合有多种不同的数据结构可供日后开发选择使用。
 *
 * Collection下面有很多细分的集合类
 * 常见的两个子类别(下述两个也是接口):
 * java.util.List:List代表的是可重复且有序的集合
 * java.util.Set:Set代表的是不可重复的集合
 *
 */
public class CollectionDemo1 {
    public static void main(String[] args) {
        //Collection c = new ArrayList();
        Collection c = new HashSet();
         /*
            boolean add(E e)
            集合提供了添加元素的方法，如果元素成功存入集合则返回true。
         */

        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        c.add("six");
        System.out.println(c);
        boolean success = c.add("one");//对于HashSet而言，本次返回值就是false，没有存入集合
        System.out.println("是否成功存入:"+success);
        System.out.println(c);
        /*
            int size()
            返回当前集合元素个数
         */

        int size = c.size();
        System.out.println("集合元素个数："+size);

        boolean isEmpty = c.isEmpty();
        System.out.println("是否为空集："+isEmpty);

        c.clear();
        System.out.println(c);
        System.out.println("集合元素个数："+c.size());
        System.out.println("是否为空集："+c.isEmpty());
    }
}
