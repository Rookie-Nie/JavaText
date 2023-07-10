package string;
/**
 * 将当前字符串中所有满足正则表达式的部分替换为给定的内容
 * String replaceAll(String regex,String replacement)
 *        替换    所有
 *
 */
public class ReplaceAllDemo {
    public static void main(String[] args) {
        String line = "abc123def456ghi789jkl";
        line = line.replaceAll("[0-9]+","#NUMBER#");
        System.out.println(line);

        String regex = "(wqnmlgb|dsb|nmsl|nc|djb|cnm|wdnmd|nmd|tmd|ntmd)";
        String message = "nmsl，你个dsb，就是个纯纯的nc，亚索都比你幸福，cnm";
        message = message.replaceAll(regex,"*****");
        System.out.println(message);
    }
}
