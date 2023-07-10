package collection;

import java.util.ArrayList;
import java.util.Collection;
/**
 * 集合转换为数组
 * Collection提供了一个方法toArray。可以将当前集合转换为一个数组
 */
public class CollectionToArrayDemo {
    public static void main(String[] args) {

        Collection<String> c = new ArrayList();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println(c);
        /*
            重载的toArray方法要求我们传入一个需要转换的数组
            长度通常与集合size一致即可。
            如果数组长度小于集合size,那么toArray方法内部会创建
            一个与该数组类型且与集合size等长的数组将其返回
         */
        String[] array = c.toArray(new String[c.size()]);
        System.out.println(array.length);
        System.out.println(array);

    }
}
