package homework.day01;

import java.util.Scanner;

/**
 * 要求用户在控制台输入自己的用户名。
 * 然后要求做如下验证工作:
 * 1:用户名不能为空(只要有一个字符)
 * 2:用户名必须在20个字以内
 * @author Xiloer
 *
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = "";
        System.out.println("请输入用户名：");
        while (true){
            name = scan.next();
            if (name != null && name.length() <= 20){
                System.out.println(name);
                return;
            }
            else
                System.out.println("输入错误，请重新输入：");
        }
    }

}
