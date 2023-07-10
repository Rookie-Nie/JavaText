package reflect;

import reflect.annotations.AutoRunClass;
import reflect.annotations.AutoRunMethod;

@AutoRunClass
public class Person {
    private String name = "张三";
    private int age = 22;

    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void hehe(){
        System.out.println("hehe是Person的私有方法！");
    }

    @AutoRunMethod
    public void sayHello(){
        System.out.println(name+":hello!");
    }
    public void sayHi(){
        System.out.println(name+":hi!");
    }
    @AutoRunMethod
    public void sleep(){
        System.out.println(name+"在睡觉!");
    }
    public void watchTV(){
        System.out.println(name+"在看电视!");
    }
    @AutoRunMethod(5)
    public void playGame(){
        System.out.println(name+"在玩游戏!");
    }
    public void say(String info){
        System.out.println(name+":"+info);
    }
    public void say(String info,int count){
        for (int i = 0;i<count;i++){
            System.out.println(name+":"+info);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
