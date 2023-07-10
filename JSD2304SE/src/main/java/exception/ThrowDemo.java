package exception;

/**
 * throw关键字
 * throw可以允许我们主动在方法中对外抛出一个异常
 * 通常以下情况我们会这样做:
 * 1:方法中出现了一个异常,但是该异常不应当在当前方法中被处理
 * 2:方法运行过程中出现了一个满足语法但是不满足业务的情况(本案例演示)
 *
 * 语法:
 * throw 异常实例;
 */
public class ThrowDemo {
    public static void main(String[] args) {
        Person p = new Person();
        /*
            当我们调用一个含有throws声明异常抛出的方法时,编译器要求我们
            必须处理该异常,处理方式有两种:
            1:使用try-catch主动捕获并处理该异常
            2:在当前方法上继续使用throws声明将该异常抛出
         */
        try {
            p.setAge(1000);//满足语法，但是不满足业务场景
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("此人年龄为："+p.getAge());
    }
}
