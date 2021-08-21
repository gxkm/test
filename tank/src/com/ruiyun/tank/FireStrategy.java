package com.ruiyun.tank;

/**
 * @Description : 开火接口策略
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/17 18:45
 */
public interface FireStrategy {
    //只有一个方法开火
    void fire(Tank t);
}
