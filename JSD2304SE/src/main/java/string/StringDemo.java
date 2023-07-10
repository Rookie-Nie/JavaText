package string;

/**
 * 字符串
 */
public class StringDemo {
    public static void main(String[] args) {
        String s1 = "123abc";
        String s2 = "123abc";//与s1使用相同字面量时会重用对象
        System.out.println("s1:"+s1);
        System.out.println(s1 == s2);//true s1和s2保存的地址相同
        String s3 = "123abc";
        System.out.println(s1 == s3);//s1和s3地址也相同

        s1 = s1 + "!";
        System.out.println("s1:"+s1);
        System.out.println("s2:"+s2);//修改s1不影响其他对象
        System.out.println(s1 == s2);//false s1指向新对象，不再与s2共用同一个对象

        String s4 = new String("123abc");//new一定产生新对象
        System.out.println("s4:"+s4);
        System.out.println(s2==s4);//false s4没有使用常量池缓存的对象

        String s5 = "123"+"abc";
        System.out.println("s5:"+s5);
        System.out.println(s2==s5);

        String s = "123";
        String s6 = s + "abc";
        System.out.println("s6:"+s6);
        System.out.println(s2==s6);    }
}
