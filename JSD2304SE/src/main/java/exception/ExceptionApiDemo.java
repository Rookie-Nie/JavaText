package exception;
/**
 * 异常常见的方法
 */
public class ExceptionApiDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了！");

        try {
            String line = "abc";
            System.out.println(Integer.parseInt(line));
        } catch (NumberFormatException e) {
            e.printStackTrace();//向控制台输出当前异常的堆栈追踪信息
            //获取错误信息一般用于提示给用户或记录日志使用
            String message = e.getMessage();//获取错误信息
            System.out.println(message);
        }

        System.out.println("程序结束了！");

    }
}
