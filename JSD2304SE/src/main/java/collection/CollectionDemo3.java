package collection;

import java.util.ArrayList;
import java.util.Collection;
/**
 * 集合可以保存一组相同类型的元素。
 * 但是集合只能存放【引用类型】元素,并且存放的是该引用类型对象的地址
 */

public class CollectionDemo3 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        Point p = new Point(1,2);
        c.add(p);
        System.out.println("p:"+p);
        System.out.println("c:"+c);

        p.setX(2);
        System.out.println("p:"+p);
        System.out.println("c:"+c);
    }
}
