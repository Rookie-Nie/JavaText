package string;
/**
 * split:拆分
 *
 * String[] split(String regex)
 * 将当前字符串按照满足正则表达式要求的部分拆分，将拆分后的每部分字符串最终以
 * 数组的形式返回。
 *
 */
import java.util.Arrays;

public class SplitDemo {
    public static void main(String[] args) {
        String line = "abc123def456ghi789jkl";
        String[] data = line.split("[0-9]+");
        System.out.println(Arrays.toString(data));

        /*
            abc123def456ghi789jkl
            ["", "123", "456", "789", ""]

            split拆分规则，如果字符串开始就可以出现可拆分项，则拆分出的第一个
            字符串为空字符串。
            str = "@a@b@c@d@e@f@"
            data = str.split("@");
            data:["", a, b, c, d, e, f]

            如果连续匹配到两个可拆分项，则中间会拆分出一个空字符串
            str = "a@@b@c@d@e@f@"
            data = str.split("@");
            data:[a, "", b, c, d, e, f]

            如果是默认拆分出空字符串时，会被【全部忽略】
            str = "a@b@c@d@e@f@@@@@@@@"
            data = str.split("@");
            data:[a, b, c, d, e, f]

         */
        data = line.split("[a-z]+");
        System.out.println(data.length);
        System.out.println(Arrays.toString(data));


        String line2 = "a=b=c=d=e=f";
        //将line2按照"="进行拆分
        String[] data2 = line2.split("=");
        System.out.println(data2.length);//6
        System.out.println(Arrays.toString(data2));
        line2 = "===a=b=c=d=e=f";//最开始会拆分出三个空字符串
        data2 = line2.split("=");
        System.out.println(data2.length);//9
        System.out.println(Arrays.toString(data2));
        line2 = "a=b=c=d=e=f======================";
        data2 = line2.split("=");//末尾的空字符串全部被忽略
        System.out.println(data2.length);//6
        System.out.println(Arrays.toString(data2));
    }
}
