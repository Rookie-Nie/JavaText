package reflect;

public class ArgDemo {
    public static void main(String[] args) {
        dosome("1");
        dosome("1","2");
        dosome("1","2","1","2","1","2","1","2","1","2","1","2","1","2","1","2","1","2","1","2");
    }

    public static void dosome(String... s){
        System.out.println(s.length);
    }
}
