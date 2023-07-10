package exception;
/**
 * finally相关面试问题
 *
 * 1:请分别说明final,finally,finalize?
 *   final:克晶老师说过的话
 *   finally:敬请参阅FinallyDemo的注释
 *   finalize:是Object当中定义的一个方法,意味着java中所有的类都有该方法.
 *            该方法是一个对象生命周期中的最后一个被调用的方法,该方法被GC调用
 *            一旦调用后该对象会被GC释放.
 *            API手册上说:Object中该方法没有任何实质操作,如果一个类重写了该
 *            方法需要注意,不应当有耗时的操作.
 *
 * 2:下面代码进行展示
 */
public class FinallyDemo3 {
    public static void main(String[] args) {
        System.out.println(test("0")+"\t"+test(null)+"\t"+test(""));
    }

    public static int test(String str){
        try{
            return  str.charAt(0)-'0';
        }catch (NullPointerException e){
            return 1;
        }catch (Exception e){
            return 2;
        }finally {
            return 3;//finally中通常不会写return
        }
    }
}
