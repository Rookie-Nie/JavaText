package exception;

/**
 * 使用当前类测试异常的抛出
 */
public class Person {
    private int age;


    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if (age<0 || age>100){
//            throw new RuntimeException("年龄不合法!");
//            throw  new Exception("年龄不合法！");
            throw  new IllegalAgeException("年龄超出范围："+age);
        }
        this.age = age;
    }
}
