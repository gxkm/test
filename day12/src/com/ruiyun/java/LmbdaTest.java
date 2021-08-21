package com.ruiyun.java;

import org.junit.Test;

import java.lang.annotation.Target;
import java.util.Comparator;

/**
 * @Description : 文件描述
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/3 16:25
 */
public class LmbdaTest {
    @Test
    public void test1(){
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("天下之大");
            }
        };
        r1.run();

        System.out.println("**************************");
        Runnable r2=() ->System.out.println("海阔天空");

        r2.run();
    }

    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare = com1.compare(12, 21);
        System.out.println(compare);

        System.out.println("***************************");
        //Lambda表达式的写法
        Comparator<Integer> com2= (o1,  o2) -> Integer.compare(o1, o2);

        int compare1 = com2.compare(32, 21);
        System.out.println(compare1);

        System.out.println("***************************");
        //方法引用
        Comparator<Integer> com3= Integer::compare;

        int compare2 = com3.compare(32, 21);
        System.out.println(compare2);

    }
}
