package com.birdboot.test;

import java.util.Arrays;

public class SplitDemo {
    public static void main(String[] args) {
        String line = "1=2=3=4=5=6=7=8=====";
        String[] data = line.split("=");
        System.out.println(Arrays.toString(data));
        //limit：拆分出的项的个数
        data = line.split("=",2);
        System.out.println(Arrays.toString(data));
        data = line.split("=",3);
        System.out.println(Arrays.toString(data));
        //当limit>最大可拆分项时，将所有可拆分项全部保留
        data = line.split("=",100);
        System.out.println(Arrays.toString(data));
        //当limit=0时，效果与split(String regex)一致
        data = line.split("=",0);
        System.out.println(Arrays.toString(data));
        //当limit<0时，表示应拆尽拆
        data = line.split("=",-1);
        System.out.println(Arrays.toString(data));
    }
}
