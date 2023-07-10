package reflect;

import reflect.annotations.AutoRunClass;
import reflect.annotations.AutoRunMethod;

@AutoRunClass
public class Student {
    private String name = "张三";
    private int age = 18;
    private char gander='男';

    public Student(){}

    public Student(String name, int age, char gander) {
        this.name = name;
        this.age = age;
        this.gander = gander;
    }

    @AutoRunMethod
    public void study(){
        System.out.println("学生"+name+":good good study,day day up!");
    }
    public void playGame(){
        System.out.println("学生"+name+":在玩游戏！");
    }
    public void sleep(){
        System.out.println("学生"+name+":在睡觉!");
    }
    @AutoRunMethod(24)
    public void doHomeWork(){
        System.out.println("学生"+name+":在写作业!");
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gander=" + gander +
                '}';
    }
}
