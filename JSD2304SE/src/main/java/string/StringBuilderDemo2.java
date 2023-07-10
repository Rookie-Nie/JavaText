package string;

public class StringBuilderDemo2 {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("a");
        for (int i = 0 ;i<100000000;i++){
            builder.append("a");
        }
        System.out.println("修改完毕");
    }
}
