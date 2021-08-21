package com.ruiyun.tank;

import abstractfactory.BaseExplode;

import java.awt.*;

/**
 * @Description : 炸弹图片
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/13 16:08
 */
public class Explode  extends BaseExplode {

    //根据ResourceMgr的图片获取宽 高
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    //炸弹坐标
    private int x, y;


//因为不要living的属性
  //  public boolean living = true;

    //TankFrame的引用
    GameModel gm=null;

    //计数，每画一次加一次
    private int step=0;

    //这里也需要持有TankFrame的引用
    public Explode(int x, int y,  GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm =gm;

       new Thread(()->new Audio("./audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {

        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if (step>= ResourceMgr.explodes.length) {
          gm.explodes.remove(this);
        }
    }
}
