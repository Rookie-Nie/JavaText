package string;
/**
 * char charAt(int index)
 * 返回当前字符串中指定下标处的字符
 * 注意:下标不可以为负数，也不可以>=字符串的length，否则会和数组下标一样
 * 出现字符串下标越界异常
 */
public class CharAt {
    public static void main(String[] args) {
        //             0123456789012345
        String line = "thinking in java";
        char c = line.charAt(9);
        System.out.println(c);
        c = line.charAt(13);
        System.out.println(c);


        String str1 = "cc";
        int i = str1.compareTo("abc");
        System.out.println(i);

    }
}
