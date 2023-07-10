package collection;

import java.util.ArrayList;
import java.util.List;

public class LIstDemo3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i< 10;i++){
            list.add(i);
        }
        System.out.println(list);
        List<Integer> subList = list.subList(3,8);  //含头不含尾
        System.out.println(subList);

        for (int i = 0;i< subList.size();i++){
            int num = subList.get(i);
            subList.set(i,num *= 10);
        }
        System.out.println(subList);
        System.out.println(list);

        list.subList(2,9).clear();
        System.out.println(list);
    }
}
