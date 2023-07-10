package string;
/**
 * boolean startsWith(String str)
 * 判断当前字符串是否是以给定的字符串str开始的
 * boolean endsWith(String str)
 * 判断当前字符串是否是以给定的字符串str结尾的
 */
public class StartsWithDemo {
    public static void main(String[] args) {
        String line = "www.tedu.com";
        boolean starts = line.startsWith("www");
        System.out.println("starts:"+starts);
        boolean ends = line.endsWith(".com");
        System.out.println("ends:"+ends);
    }
}
