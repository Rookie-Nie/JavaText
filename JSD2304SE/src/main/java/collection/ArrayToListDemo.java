package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 数组转换为集合
 * 数组的工具类Arrays提供了一个静态方法asList
 * 可以将一个数组转换为一个List集合
 */
public class ArrayToListDemo {
    public static void main(String[] args) {
        String[] array = {"one","two","three","four","five"};
        System.out.println("array:"+Arrays.toString(array));
        /*
            asList方法内部:
            创建一个名为ArrayList的实例(注意，它不是java.util.ArrayList
            而是Arrays自己定义的一个内部类)。该实例会直接引用传入的数组。
            因此对该集合的操作就是对该数组的操作。
         */
        List<String> list = Arrays.asList(array);
        System.out.println("list:"+list);

        list.set(2,"six");
        System.out.println("list:"+list);
        System.out.println("array:"+Arrays.toString(array));

        //因为数组定长，所以试图改变长度的操作都是不支持的，会抛出不支持操作异常
        //java.lang.UnsupportedOperationExceptio
//        list.add("seven");
//        System.out.println("list:"+list);
//        System.out.println("array:"+Arrays.toString(array));

//        List<String> list2 = new ArrayList<>();
//        list2.addAll(list);
        /*
            可以自行创建一个新集合，然后包含前面数组转换的集合，这样就可以
            随意的修改元素了且不会对原数组产生影响。
         */
        List<String> list2 = new ArrayList<>(list);
        list2.add("seven");
        System.out.println("list2:"+list2);
    }
}
