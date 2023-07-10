package object;

public class TestPoint {
    public static void main(String[] args) {
        Point p = new Point(6,9);
        System.out.println(p);

        String line = "当前对象是："+p;
        System.out.println(line);

        Point p2 = new Point(6,9);
        System.out.println("p2:"+p2);
        System.out.println(p == p2);//false  两个不同的对象
        System.out.println(p.equals(p2));//true  两个对象内容相同
    }
}
