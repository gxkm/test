package com.ruiyun.java1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description : 文件描述
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/4 17:03
 */
public class EmployeeData {
    public static List<Employee> getEmployees(){
        ArrayList<Employee> list = new ArrayList<>();
         list.add(new Employee(1001,"马化腾",34,6000.38));
         list.add(new Employee(1002,"马云",12,3000.38));
         list.add(new Employee(1003,"刘强东",31,7000.38));
         list.add(new Employee(1004,"李彦宏",44,8000.38));
         list.add(new Employee(1005,"任正非",64,4000.38));
         list.add(new Employee(1006,"雷军",64,4000.38));
         list.add(new Employee(1007,"任正非7",64,4000.38));
         list.add(new Employee(1008,"任正非8",64,4000.38));
         list.add(new Employee(1009,"任正非9",64,4000.38));
         list.add(new Employee(1010,"任正非10",64,4000.38));
      return list;
    }
}
