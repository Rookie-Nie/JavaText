package string;
/**
 * String substring(int startIndex,int endIndex)
 * 截取当前字符串中startIndex到endIndex之间的字符。
 * 注意，在javaAPI中当使用两个数字表示范围时，都是"含头不含尾"的
 */
public class SubstringDemo {
    public static void main(String[] args) {
        //             01234567890
        String line = "www.tedu.cn";
        String sub = line.substring(4,8);       //含头不含尾
        System.out.println(sub);

        sub = line.substring(4);
        System.out.println(sub);
    }
}
