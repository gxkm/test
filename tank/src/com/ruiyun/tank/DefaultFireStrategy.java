package com.ruiyun.tank;

/**
 * @Description : 默认开火策略
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/17 18:49
 */
public class DefaultFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank t) {
        //子弹的位置
        int bX=t.getX()+Tank.WIDTH/2-Bullet.WIDTH/2;
        int bY=t.getY()+Tank.HEIGHT/2-Bullet.HEIGHT/2;
        //得到TankFrame的引用就可以使用属性b 来接收Bullet对象
        new Bullet(bX, bY, t.getDir(),t.getGroup(), t.gm);
        if (t.getGroup()==Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
