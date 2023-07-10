package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合受元素equals影响的相关操作:
 * contains判断包含
 * remove删除元素
 */
public class CollectionDemo2 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add(new Point(1,2));
        c.add(new Point(3,4));
        c.add(new Point(5,6));
        c.add(new Point(7,8));
        c.add(new Point(9,0));
        c.add(new Point(1,2));
        /*
            集合重写了toString，格式为:
            [元素1.toString(), 元素2.toString(), 元素3.toString(), ...]

            由此可见，想更直观的体现元素时，元素也需要妥善重写toString方法。
         */
        System.out.println(c);

        Point p = new Point(1,2);
        /*
            contains:包含
            boolean contains(Object o)
            判断当前集合是否包含给定元素，若包含则返回true，否则返回false
            这里判断包含的逻辑是:给定元素是否与集合现有元素存在equals比较为
            true的情况，如果有则认为包含该元素。否则为不包含。
         */
        boolean contains = c.contains(p);
        System.out.println("是否包含："+contains);
        /*
            boolean remove(Object o)
            删除当前集合中给定元素。
            删除的逻辑也是删除集合中与参数给定元素equals比较为true的元素。

            注意:如果集合存在重复元素，那么在删除重复元素时，remove方法
            仅会删除一次。
         */
        c.remove(p);
        System.out.println(c);
    }
}
