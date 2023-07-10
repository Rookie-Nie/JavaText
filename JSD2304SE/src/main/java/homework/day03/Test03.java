package homework.day03;

import java.util.*;

/**
 * 生成10个0-100之间的不重复的随机数,并输出
 * @author Xiloer
 *
 */
public class Test03 {
	public static void main(String[] args) {
		Random rand = new Random();
		Collection<Integer> list = new HashSet<>();
		while (list.size() <= 10){
			list.add(rand.nextInt(101));
		}
		System.out.println(list);
	}
}
