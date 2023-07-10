package homework.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 在一个List集合中生成20个随机整数(100以内)
 * 然后按照从小到大的顺序排列，排好后再将第6个-第15个元素
 * 按照从大到小顺序排列，并最终输出集合
 * 例如:
 * 1,2,3,4,5,15,14,13,12,11,10,9,8,7,6,16,17,18,19,20
 * @author pc
 *
 */
public class Test01 {
	public static void main(String[] args) {
		Random rand = new Random();
		List<Integer> list = new ArrayList<>();
		for (int i = 0;i<20;i++){
			list.add(rand.nextInt(100));
		}
		list.sort((n,m)->n-m);
		System.out.println(list);

		List<Integer> subList = list.subList(5,15);
		subList.sort((n,m)->m-n);
//		System.out.println(subList);
		System.out.println(list);

	}
}








