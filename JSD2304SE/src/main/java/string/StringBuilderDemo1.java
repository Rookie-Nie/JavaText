package string;
/**
 * java.lang.StringBuilder
 * 专门用来修改字符串内容的工具类
 * 其提供了对字符串内容编辑的:增删改插的主要功能
 *
 * StringBuilder内部维护一个可变的char数组，所以修改内容不会创建新的String对象
 */
public class StringBuilderDemo1 {
    public static void main(String[] args) {
        String str = "Hello";
        /*
            StringBuffer与StringBuilder功能一致
            区别:
            StringBuffer出现与JDK1.0   StringBuilder出现于1.5
            最主要的区别:StringBuffer是并发安全的。StringBuilder不是
         */
        //StringBuilder builder = new StringBuilder(str);
        StringBuffer builder = new StringBuffer(str);

        /*
            增:
            append()方法，用来将给定内容添加到字符串末尾
            "好好学习java"
                 V
            "好好学习java,为了找个好工作!"
         */
        builder.append("，World！");
        String line = builder.toString();
        System.out.println(line);

        /*
            改:
            replace()
            将当前字符串中指定范围内的内容替换为新内容
            "好好学习java,为了找个好工作!"
                        V
            "好好学习java,就是为了改变世界!"
         */
        //              注意，下标含头不含尾
        builder.replace(6,11,"你好");
        System.out.println(builder.toString());

        /*
            删:
            delete()
            将当前字符串中指定范围内的字符串删除

            "好好学习java,就是为了改变世界!"
                        V
            ",就是为了改变世界!"
         */
        builder.delete(5,8);
        System.out.println(builder);

        /*
            插:
            insert()
            将给定内容插入到当前字符串中的指定位置
            ",就是为了改变世界!"
                    V
            "活着,就是为了改变世界!"
         */
        builder.insert(5,"，你个吊毛");
        System.out.println(builder);

        //逆置
        builder.reverse();
        System.out.println(builder);
    }
}
