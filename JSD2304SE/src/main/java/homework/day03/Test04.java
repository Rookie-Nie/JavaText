package homework.day03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 将整数1-100存入一个List集合中并输出
 * 之后将集合中40-60的元素翻转后并输出
 * 
 * @author Xiloer
 *
 */
public class Test04 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1;i<=100;i++){
            list.add(i);
        }
        System.out.println(list);
        List<Integer> subList = list.subList(39,60);//标记40-60的元素
        Collections.reverse(subList);//逆置

        System.out.println(subList);
        System.out.println(list);
    }

}
