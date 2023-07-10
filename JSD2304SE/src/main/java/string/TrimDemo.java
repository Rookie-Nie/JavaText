package string;
/**
 * String trim()
 * 去除字符串两侧的空白字符
 */
public class TrimDemo {
    public static void main(String[] args) {
        String line = "   Hello World         ";
        System.out.println(line);
        String trim = line.trim();
        System.out.println(trim);
    }
}
