package string;
/**
 * String toUpperCase()
 * 将当前字符串中的英文部分转换为全大写
 *
 * String toLowerCase()
 * 将当前字符串中的英文部分转换为全小写
 */
public class ToUpperCase {
    public static void main(String[] args) {
        String str = "我爱Java";
        String upper = str.toUpperCase();
        System.out.println(upper);
        String lower = str.toLowerCase();
        System.out.println(lower);

        String img = "2Y3n7sOp";
        String input = "2y3n7sop";
        /*img = img.toLowerCase();
        input = img.toLowerCase();
        boolean match = img.equals(input);*/
        boolean match = img.equalsIgnoreCase(input);
        System.out.println("输入"+(match?"正确":"错误"));
    }
}
