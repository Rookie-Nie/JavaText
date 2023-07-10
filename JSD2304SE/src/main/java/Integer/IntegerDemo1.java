package Integer;
/**
 *  包装类
 *  java为8个基本类型提供了8个包装类。
 *  包装类的出现是为了解决8个基本类型不能直接参与面向对象开发的问题。本质上讲
 *  就是可以通过包装类让基本类型以"对象"的形式出现。
 *
 *  int->Integer
 *  char->Character
 *  其他包装类的类名与基本类型一致，只是首字母大写。
 *  double->Double
 *  ...
 */
public class IntegerDemo1 {
    public static void main(String[] args) {
        int i =128  ;
//        Integer i1 = new Integer(i);
//        Integer i2 = new Integer(i);
        /*
            包装类提供了静态方法valueOf,可以将对应的基本类型转换为包装类
            推荐这种方式，而不是直接new。
            Integer的valueOf会像字符串String一样，去缓存对象。但是它只
            缓存-128到127之内的数字。其余的全部为new。
         */
        Integer i1 = Integer.valueOf(i);
        Integer i2 = Integer.valueOf(i);

        System.out.println(i1 == i2);
        //包装类java提供时已经重写过equals方法了，用来比较对象内容
        System.out.println(i1.equals(i2));

        double d = 123.123;
        Double d1 = Double.valueOf(d);
        Double d2 = Double.valueOf(d);
        System.out.println(d1 == d2);
        System.out.println(d1.equals(d2));

        int in = i1.intValue();
        System.out.println(in);
        long lon = i1.longValue();
        System.out.println(lon);
        byte b = i1.byteValue();
        System.out.println(b);

        in = d1.intValue();
        System.out.println(in);
        double dou = d1.doubleValue();
        System.out.println(dou);
    }
}
