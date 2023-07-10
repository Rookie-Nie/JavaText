package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合的遍历
 *              die(二声)
 * 集合的遍历是采取迭代器模式
 *
 * 集合提供了一个方法
 * Iterator iterator()
 * 该方法可以获取一个用于遍历当前集合的迭代器
 *
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection c= new ArrayList();
        c.add("one");
        c.add("#");
        c.add("two");
        c.add("#");
        c.add("three");
        c.add("#");
        c.add("four");
        c.add("#");
        c.add("five");
        c.add("#");
        c.add("six");
        Iterator iterator = c.iterator();
        /*
            boolean hasNext()
            询问集合是否还有下一个元素
            E next()
            获取集合下一个元素
         */
        while (iterator.hasNext()){
            String str = (String) iterator.next();
            /*书写习惯:字符串变量与字面比较时用字面量.equals(变量)，避免空指针的产生
            if(str.equals("#")){*/
            if ("#".equals(str)){
                //c.remove(str);        //迭代器要求遍历的过程中不可以用集合的方法增删元素，否则会抛出异常
                //迭代器提供的remove可以删除集合中本次next获取的元素
                iterator.remove();
            }
            System.out.println(str);
        }
        System.out.println(c);
    }
}
