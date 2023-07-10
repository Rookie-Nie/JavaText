package string;
/**
 * String提供了一套重载的静态方法:valueOf
 * 作用是将java中其他类型转换为字符串
 */
public class ValueOfDemo {
    public static void main(String[] args) {
        int i = 1234;
        String s1 = String.valueOf(i);
        System.out.println(s1);

        double j = 1234.123;
        String s2 = String.valueOf(j);
        System.out.println(s2);

        String s3 = i+"";
        System.out.println(s3);

        boolean b = false;
        String s4 = String.valueOf(b);
        System.out.println(s4);
    }
}
