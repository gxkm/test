package com.ruiyun.java;

import com.ruiyun.java1.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Description : 文件描述
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/4 15:07
 */
public class MethodRefTest {
    //情况一：对象::实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1(){
        Consumer<String> con1=str->System.out.println(str);
        con1.accept("北京");

        System.out.println("***********************");
        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("beijing");
    }

    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void test2(){
        Employee emp = new Employee(1001, "Tom", 23, 5600);
        Supplier<String> sup1=()-> emp.getName();
        System.out.println(sup1.get());

        System.out.println("***********************");
        Supplier<String> sup2=emp::getName;
        System.out.println(sup2.get());
    }

    //情况二： 类  ：：静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare(T t1, T  t2)
    @Test
    public void test3(){
        Comparator<Integer> com1=(t1,t2) ->Integer.compare(t1,t2);
        System.out.println(com1.compare(12, 21));
        System.out.println("***********************");

        Comparator<Integer> com2=Integer::compare;
        System.out.println(com2.compare(21, 11));
    }

    //Function中的R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test4(){
        Function<Double, Long> func = new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);
            }
        };
        System.out.println("***********************");
        Function<Double,Long> func1=d->Math.round(d);
        System.out.println(func1.apply(12.3));
        System.out.println("***********************");
        Function<Double,Long> func2=Math::round;
        System.out.println(func2.apply(14.6));

    }

    //情况三：类 ：：实例方法  (有难度)
    //Comparator 中的int compare(T t1,T t2)
    //String 中的 int t1.compareTo(t2)
    @Test
    public void test5(){
        Comparator<String > com1=(s1,s2)-> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "abd"));
        System.out.println("***********************");
        Comparator<String> com2=String::compareTo;
        System.out.println(com2.compare("abd", "abm"));

    }

    //BiPredicate中的boolean test(T t1,T t2)
    //String 中的boolean t1.equals(t2)
    @Test
    public void test6(){
        BiPredicate<String ,String> pre1=(s1,s2)->s1.equals(s2);
        System.out.println(pre1.test("abc", "abc"));
        System.out.println("***********************");
        BiPredicate<String ,String> pre2=String::equals;
        System.out.println(pre2.test("abc", "abd"));
    }

    //Function中的R apply(T t)
    //Employee中的String getName();
    @Test
    public void test7(){
        Employee emp = new Employee(1001, "Herry", 23, 6000);
        Function<Employee,String >  func1=e->e.getName();
        System.out.println(func1.apply(emp));
        System.out.println("***********************");
        Function<Employee,String >  func2=Employee::getName;
        System.out.println(func2.apply(emp));
    }
}
