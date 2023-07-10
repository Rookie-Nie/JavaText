package exception;
/**
 * finally块
 * finally块是异常处理机制中的最后一块.它可以直接跟在try之后或者最后一个catch之后
 *
 * finally的特点:只要程序执行到try当中,无论try中的代码是否出现异常,最终都要
 * 执行finally中的代码
 *
 * 通常使用finally用于完成资源释放这类操作,比如IO后的关闭操作.
 */
public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了！");
        try {
            String line = "";
            System.out.println(line.length());
            //当try中某句代码出现异常后,try中剩余代码就不会被执行了
            return;//try中就算执行到return,也要在结束方法前先走完下面的finally
        }catch (Exception e){
            System.out.println("出错了！");
        }finally {
            System.out.println("finally中的代码实现了！");
        }
        System.out.println("程序结束了!");
    }
}
