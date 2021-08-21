package com.ruiyun.tank;

import abstractfactory.BaseBullet;
import abstractfactory.BaseExplode;
import abstractfactory.DefaultFactory;
import abstractfactory.GameFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description : 自己把自己画出来，严格说是一个单例
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/20 21:39
 */
public class GameModel {

    Tank myTank=new Tank(200,400,Dir.DOWN,Group.GOOD,this);
    //创建子弹的容器
    public java.util.List<BaseBullet> bullets=new ArrayList<>();
    //用容器装坦克
    public List<Tank> tanks=new ArrayList<>();

    //new一个爆炸
    //   Explode e=new Explode(100, 100, this);
    //容器装爆炸
    public List<BaseExplode> explodes = new ArrayList<>();

    //初始化一个工厂，以便于生产
    public GameFactory gf=new DefaultFactory();

    public GameModel() {
        //调用配置文件数据 10个坦克
        int initTankCount=  PropertyMgr.get("initTankCount");
        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            tanks.add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,this));
        }
    }

    public void paint(Graphics g) {
        Color c=g.getColor();
        g.setColor(Color.CYAN);
        g.drawString("子弹的数量： "+bullets.size(), 10, 60);
        g.drawString("敌方坦克数量： "+tanks.size(), 10, 80);
        g.drawString("爆炸的数量： "+explodes.size(), 10, 100);
        g.setColor(c);
        myTank.paint(g);
//        for (Bullet b : bullets) {  //这个一个在使用Iterator迭代器遍历时，同时用使用remove()方法进行了删除的操作。
//                                      报异常 java.util.ConcurrentModificationException
//            b.paint(g);
//        }
        //方式一：
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
        //画出敌方坦克
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }
        //画出容器里的爆炸
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

        //子弹与坦克做碰撞检测
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collidWith(tanks.get(j));
            }
        }

        //方式二：
//        for (Iterator<Bullet> it=bullets.iterator();it.hasNext();){
//            Bullet b=it.next();
//            b.paint(g);
//            if (!b.live) it.remove();
//        }
    }

    public Tank getMainTank() {

        return  myTank;
    }
}
