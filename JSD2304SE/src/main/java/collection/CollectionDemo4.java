package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 集合之间的操作
 */
public class CollectionDemo4 {
    public static void main(String[] args) {
        //Collection c1 = new ArrayList();
        Collection c1 = new HashSet();
        c1.add("java");
        c1.add("c++");
        c1.add(".net");
        System.out.println("c1:"+c1);
        Collection c2 = new ArrayList();
        c2.add("android");
        c2.add("ios");
        c2.add("java");
        System.out.println("c2:"+c2);
        /*
            boolean addAll(Collection c)
            将给定集合c中的所有元素添加到当前集合中。添加后当前集合元素发生
            了变化则返回true。
         */
        c1.addAll(c2);
        System.out.println("c1:"+c1);
        System.out.println("c2:"+c2);
        /*
            boolean containsAll(Collection c)
            判断当前集合是否包含给定集合中的所有元素。
            全部包含则返回true，否则返回false
         */
        Collection c3 = new ArrayList();
        c3.add("java");
        c3.add("android");
        //c3.add("php");
        System.out.println("c3:"+c3);
        boolean containsAll = c1.containsAll(c3);
        System.out.println("c1是否包含c3的所有元素："+containsAll );
        /*
            取交集操作
            boolean retainAll(Collection c)
            仅保留当前集合中与给定集合c的共有元素。
         */
        /*c1.retainAll(c3);
        System.out.println("c1:"+c1);*/
        /*
        差集操作（删除交集部分）
        removeAll可以删除当前集合中与给定集合的公有元素
         */
        c1.removeAll(c3);
        System.out.println("c1:"+c1);
    }
}
