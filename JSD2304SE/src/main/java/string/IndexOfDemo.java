package string;

public class IndexOfDemo {
    public static void main(String[] args) {
        //             0123456789012345
        String line = "thinking in java";
        int index = line.indexOf("in");
        System.out.println(index);

        //从下标3处开始检索第一次出现“in”的位置
        index = line.indexOf("in",3);
        System.out.println(index);

        //检索当前字符串中最后一次出现“in”的位置
        index = line.lastIndexOf("in");
        System.out.println(index);

        //如果当前字符串检索中不含有指定内容则返回值为-1
        index = line.indexOf("IN");
        System.out.println(index);
    }
}
