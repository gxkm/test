package com.ruiyun.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @Description : 文件描述
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/16 16:27
 */
public class PropertyMgr {
    //Properties里面包含key value
  static  Properties props=new Properties();
  static {
      try {
          props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
    public static  int get(String key){
        if (props==null) {
            return 0;
        }
        return Integer.parseInt((String) props.get(key));
    }
 public static  Object getObej(String key){
        if (props==null) {
            return 0;
        }
        return  props.get(key);
    }


    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("gameWidth"));
    }

}
