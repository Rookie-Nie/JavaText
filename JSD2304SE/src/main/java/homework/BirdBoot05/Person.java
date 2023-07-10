package homework.BirdBoot05;

public class Person {
    private String name = "张三";
    private int age = 18;
    private char sex = '男';

    public Person(){}
    public Person(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }


    public void sayHello(){
        System.out.println(name+":hello!");
    }
    public void sayHi(){
        System.out.println(name+":hi!");
    }
    public void say(String info){
        System.out.println(name+":"+info);
    }
    public void say(String info,int count){
        for (int i =0;i<count;i++){
            System.out.println(name+":"+info);
        }
    }
    public void eat(){
        System.out.println(name+":正在吃东西！");
    }
    public void sleep(){
        System.out.println(name+":正在睡觉！");
    }
    public void run(){
        System.out.println(name+":正在跑步！");
    }
    public void play(){
        System.out.println(name+":正在玩！");
    }
    private void haha(){
        System.out.println("这是Person的私有方法haha!");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
