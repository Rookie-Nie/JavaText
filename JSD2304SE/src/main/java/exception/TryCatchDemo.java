package exception;
/**
 * java异常处理机制
 * 语法:
 * try{
 *     可能出现异常的代码片段(A计划)
 * }catch(XXXException e){
 *     try中出现XXXException后的处理代码(B计划)
 * }
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        try {
//            String line = null;
//            String line = "";
            String line = "a";
             /*
            当JVM执行程序是出现了某个异常时,就会实例化对应的异常实例并将其
            抛出.此时虚拟机会检查报错的这句代码是否有被异常处理机制处理,如果
            没有则会继续将该异常抛出到当前方法之外(比如这里会抛出到main方法之外)
            如果异常最终被抛出到main方法意味着当前程序就结束了.
              */
            System.out.println(line.length());
            System.out.println(line.charAt(0));
            System.out.println(Integer.parseInt(line));
        } catch (NullPointerException|StringIndexOutOfBoundsException e){
            System.out.println("出现了空指针或下标越界，在这里解决了！");
            //捕获一个超类型异常时,try中出现它的子类型异常都可以被其捕获
            //多个catch存在继承关系时,子类型在上先捕获.超类在下后捕获.
            //上面的catch捕获异常后,下面的catch就不执行了
        }catch (Exception e){
            System.out.println("反正就是出了个错");
        }

        System.out.println("程序结束了！");
    }
}
