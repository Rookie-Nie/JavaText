package io;

import java.io.Serializable;
import java.util.Arrays;

public class Person implements Serializable {
    private String name;
    private int age;
    private  String gender;
    private transient String[] otherInfo;
    /*
            transient关键字
            被该关键字修饰的属性在进行对象序列化是会被忽略。
            忽略不必要的属性可以达到对象序列化的"瘦身"目的，减少不必要的开销
            持久化时可以降低磁盘空间的开销。网络传输时可以提高传输速度
    */
    public Person(String name, int age, String gender, String[] otherInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.otherInfo = otherInfo;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", otherInfo=" + Arrays.toString(otherInfo) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String[] otherInfo) {
        this.otherInfo = otherInfo;
    }
}
