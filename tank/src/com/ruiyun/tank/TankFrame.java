package com.ruiyun.tank;

import abstractfactory.*;
import sun.java2d.pipe.DrawImage;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description : 文件描述
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/12 23:16
 */
public class TankFrame extends Frame {
//    //将坦克坐标改为变量
//    int x = 200, y = 200;
//    //给出坦克四个方向
//    Dir dir = Dir.DOWN;
//    //给出坦克默认速度
//   private static final int SPEED = 10;

    GameModel gm = new GameModel();




    // Bullet b=new Bullet(300, 300, Dir.DOWN);

    public static final int GAME_WIDTH = PropertyMgr.get("gameWidth"), GAME_HEIGHT = PropertyMgr.get("gameHeight");

    public TankFrame() throws HeadlessException {

        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false); //设置此框架是否可由用户调整大小。
        setTitle("tank war by jack.wong");
        setVisible(true);

        //添加键盘监听事件
        this.addKeyListener(new MyKeyListener());
        //关闭窗口自动销毁
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {

        gm.paint(g);


    }

    /*
    添加键盘监听事件内部类
     */
    class MyKeyListener extends KeyAdapter {
        //避免左右上下键同时按下的处理方法，设置四个按键是否按下
        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        /*
        监听按下
         */
        @Override
        public void keyPressed(KeyEvent e) {
            // System.out.println("keyPressed");
//            x+=200;
//            repaint();
            //获取被按下键的代码
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    // x-=10;
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    // x+=10;
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    // y-=10;
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    // y+=10;
                    bD = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    gm.getMainTank().fire();
                    break;

                default:
                    break;
            }

            setMainTankDir();

        }


        /*
        监听键盘按键抬起
         */
        @Override
        public void keyReleased(KeyEvent e) {
            //  System.out.println("keyReleased");
            //获取被按下键抬起的代码
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    // x-=10;
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    // x+=10;
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    // y-=10;
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    // y+=10;
                    bD = false;
                    break;


                default:
                    break;
            }
            setMainTankDir();
        }

        /*
     按下去坦克方向
      */
        private void setMainTankDir() {
            Tank myTank = gm.getMainTank();

            //当!bL&&!bU&&!bR&&!bD 同时都没有按下，就设置moving为false
            if (!bL && !bU && !bR && !bD)
                myTank.setMoving(false);
            else {
                myTank.setMoving(true);
                if (bL)
                    myTank.setDir(Dir.LEFT);
                if (bR)
                    myTank.setDir(Dir.RIGHT);
                if (bU)
                    myTank.setDir(Dir.UP);
                if (bD)
                    myTank.setDir(Dir.DOWN);
            }

        }
    }
}
