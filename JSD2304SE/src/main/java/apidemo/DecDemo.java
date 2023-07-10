package apidemo;

/**
 * 文档注释
 * 文档注释是功能级别的注释，用来说明类，方法和常量的功能。
 * 文档注释可以通过javadoc命令生成手册（与官方api手册一样的一套页面）
 *
 * 在类上使用时，用来说明当前类的整体作用和功能介绍
 * @author nie      //作者
 * @version 1.0     //版本
 */
public class DecDemo {

    /**
     * 用于为指定的用户添加问候语
     * @param name 需要添加问候语的用户名
     * @return  一段带问候语的字符串
     */
    public String sayHello(String name){
        return  "你好"+name;
    }
}
