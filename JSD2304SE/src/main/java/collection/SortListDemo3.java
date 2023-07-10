package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListDemo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("传奇老师");
        list.add("王克晶");
        list.add("刘桑");

        System.out.println(list);
//        Collections.sort(list);       //默认按Unicode的值进行排序，不符合中文排序需求
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();//字多的大，字少的小
            }
        });
        System.out.println(list);

    }
}
