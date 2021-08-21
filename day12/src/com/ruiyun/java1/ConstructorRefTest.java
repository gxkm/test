package com.ruiyun.java1;

import org.junit.Test;


import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Description : 文件描述
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/4 16:16
 */
public class ConstructorRefTest {
    //构造器引用
    //Supplier中的 T get()
    //Employee 的空参构造器：Employee（）
    @Test
    public void test1(){
        Supplier<Employee> supplier = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(supplier.get());

        System.out.println("**************");

        Supplier<Employee>  sup1=()->new Employee();
        System.out.println(sup1.get());

        System.out.println("**************");

        Supplier<Employee>  sup2=Employee::new;
        System.out.println(sup2.get());
    }

    //Function 中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer,Employee> func1=id-> new Employee(id);
        Employee employee = func1.apply(101);
        System.out.println(employee);

        System.out.println("**************");
        Function<Integer,Employee> func2=Employee::new;
        Employee employee1 = func2.apply(102);
        System.out.println(employee1);
    }

    //BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<Integer,String,Employee> func1=(id,name)->new Employee(id,name);
        System.out.println(func1.apply(101, "jack"));

        System.out.println("**************");
        BiFunction<Integer,String,Employee> func2=Employee::new;
        Employee katter = func2.apply(102, "katter");
        System.out.println(katter);
    }

    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer,String[]> func1=length->new String[length];
        String[] arr1 = func1.apply(5);
        System.out.println(Arrays.toString(arr1));

        System.out.println("**************");

        Function<Integer,String[]> func2=String[]::new;
        String[] arr2 = func1.apply(10);
        System.out.println(Arrays.toString(arr2));

    }
}
