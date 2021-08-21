package com.ruiyun.tank;

import java.awt.*;
import java.util.Random;

/**
 * @Description : 文件描述
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/13 15:12
 */
public class Tank {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = PropertyMgr.get("tankSpeed");

    //坦克的宽，高
    public static int WIDTH = ResourceMgr.goodTankD.getWidth();
    public static  int HEIGHT = ResourceMgr.goodTankD.getHeight();

    //创建坦克的矩形
  public   Rectangle rect=new Rectangle();
    //坦克移动随机数
    private Random random=new Random();


    //怎么样处理坦克静止状态
    private boolean moving = true;

    //坦克成活的属性
    private boolean living=true;

    //创建成员变量、
    FireStrategy fs;

    //大管家
    GameModel gm;

    //给坦克归类、默认是BAD
    private  Group group=Group.BAD;

    public Tank() {
    }

    public Tank(int x, int y, Dir dir,Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group=group;
        this.gm = gm;

        rect.x=this.x;
        rect.y=this.y;
        rect.width=WIDTH;
        rect.height=HEIGHT;

        //在这里做一个判断，如果是goodtank就是用四个方向开火，如果是badtank就只能是默认开火
        if(group==Group.GOOD) {
          String goodFSName= ((String)PropertyMgr.getObej("goodFS"));
            try {
                fs = (FireStrategy) Class.forName(goodFSName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else fs=new DefaultFireStrategy();

    }

    public void paint(Graphics g) {
        //判断坦克是否活着，最好是把容器里对应的坦克remove
        if (!living) {
            gm.tanks.remove(this);
        }
        //根据方向来画坦克
        switch (dir) {
            case LEFT:
                g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankL:ResourceMgr.badTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankR:ResourceMgr.badTankR, x, y, null);
                break;
            case UP:
                g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankU:ResourceMgr.badTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankD:ResourceMgr.badTankD, x, y, null);
                break;
        }

//        Color c=g.getColor();
//        g.setColor(Color.YELLOW);
//        g.fillRect(x, y, 50, 50);
//        g.setColor(c);
        // x += 10;
//        y+=10;
        move();
    }

    //判断方向
    private void move() {
        if (!moving) return;

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;

        }
        //每次移动后，update rect
        rect.x=this.x;
        rect.y=this.y;

    //    if (this.group==Group.GOOD) new Thread(()->new Audio("audio/tank_move.wav").play()).start();
        //判断是坏坦克，并且几率为5%就发射炮弹
        if (this.group==Group.BAD&&random.nextInt(100)>95)
            this.fire();
        if (this.group==Group.BAD&&random.nextInt(100)>95)
        //坦克的随机方向
             randomDir();

        //做坦克的边界检测
        boundsCheck();
    }

    //做坦克的边界检测
    private void boundsCheck() {
        //如果坦克的X<2 的时候，就把X设置为2
        if (this.x<2) x=2;
        //如果坦克的y<28 的时候，就把y设置为28
        if (this.y<28) y=28;
        //如果坦克的X>窗口宽度-坦克的宽度-2 的时候，就把X设置为窗口宽度-坦克的宽度-2
        if (this.x>TankFrame.GAME_WIDTH-Tank.WIDTH-2) x=TankFrame.WIDTH-Tank.WIDTH-2;
        //如果坦克的y>窗口宽度-坦克的宽度-2 的时候，就把y设置为窗口宽度-坦克的宽度-2
        if (this.y>TankFrame.GAME_HEIGHT-Tank.HEIGHT-2) y=TankFrame.GAME_HEIGHT- Tank.HEIGHT-2;
    }

    //
    private void randomDir() {
        //使用Dir.values()获取值，使用random.nextInt(4)来获取下标，这样就可以获取到L,R,U,D
        this.dir=Dir.values()[random.nextInt(4)];
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    /*
    打出子弹
     */
    public void fire() {
      fs.fire(this);

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //坦克被子弹撞上就die了
    public void die() {
        this.living=false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
