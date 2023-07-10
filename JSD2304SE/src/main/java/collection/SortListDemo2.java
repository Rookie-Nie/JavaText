package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * 排序包含自定义类型元素的集合
 */
public class SortListDemo2 {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(1,2));
        list.add(new Point(45,23));
        list.add(new Point(75,34));
        list.add(new Point(48,9));
        list.add(new Point(59,25));
        System.out.println(list);
/*
            sort方法在排序时要求集合元素必须实现:Comparable接口
            compare:比较

            开发中我们定义的类不会去实现Comparable接口。原因:
            该排序功能对我们的代码具有侵入性。

            侵入性:
            当我们使用某个API功能是，其放过来要求我们为它实现接口或做某些继承
            并定义相关方法时，可以认定，该API功能对我们的代码具有侵入性。
         */
//        Collections.sort(list); //编译不通过


        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int olen1 = o1.getX()* o1.getX() + o1.getY()* o1.getY();
                int olen2 = o2.getX()* o2.getX() + o2.getY()* o2.getY();
                return olen1-olen2;
            }
        });
        System.out.println(list);
    }
}

