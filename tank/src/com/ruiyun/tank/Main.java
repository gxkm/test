package com.ruiyun.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Description : 文件描述
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/12 22:14
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        //在主线程每隔50毫秒刷新窗口，调用repaint()会自动调用paint()
        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}