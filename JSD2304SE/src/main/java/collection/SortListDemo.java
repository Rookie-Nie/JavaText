package collection;

import java.util.*;
/**
 * 集合的排序
 * java.util.Collections是集合的工具类，提供了很多static方法用于操作集合
 * 其中提供了一个名为sort的方法，可以对List集合进行自然排序(从小到大)
 */

public class SortListDemo {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<10;i++){
            list.add(rand.nextInt(100));
        }
        System.out.println(list);
//        Collections.sort(list);     //对集合进行排序，从小到大
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(list);

//        Collections.shuffle(list);        //将list集合乱序
//        System.out.println(list);
    }
}
