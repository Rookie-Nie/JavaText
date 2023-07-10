package homework.BirdBoot05;

public class Student {
    private String name = "李四";
    private int age = 20;
    private String score = "001";

    public Student(){}

    public Student(String name, int age, String score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }


    public void eat(){
        System.out.println("学生"+name+"正在吃饭！");
    }
    public void run(){
        System.out.println("学生"+name+"正在跑步！");
    }
    public void sleep(){
        System.out.println("学生"+name+"正在休息！");
    }
    public void stay(){
        System.out.println("学生"+name+"正在学习！");
    }



    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score='" + score + '\'' +
                '}';
    }
}
