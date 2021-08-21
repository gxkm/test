package com.ruiyun.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Description : ResourceMgr类管理资源
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/14 18:05
 */
public class ResourceMgr {
   public  static BufferedImage goodTankL,goodTankR,goodTankU,goodTankD;
   public  static BufferedImage badTankL,badTankR,badTankU,badTankD;
   //子弹的图形
   public  static BufferedImage bulletL,bulletR,bulletU,bulletD;

   //爆炸图片数组
   public static BufferedImage[] explodes=new BufferedImage[16];

   static {
      try {
//         tankL= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
//         tankD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
//         tankR=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
         goodTankU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
         goodTankL=ImageUtil.rotateImage(goodTankU, -90);
         goodTankR=ImageUtil.rotateImage(goodTankU, 90);
         goodTankD=ImageUtil.rotateImage(goodTankU, 180);


         badTankU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
         badTankL=ImageUtil.rotateImage(badTankU, -90);
         badTankR=ImageUtil.rotateImage(badTankU, 90);
         badTankD=ImageUtil.rotateImage(badTankU, 180);


         //获取子弹在Resource里面图
//         bulletL=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
//         bulletR=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
         bulletU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
//         bulletD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
         bulletL=ImageUtil.rotateImage(bulletU, -90);
         bulletR=ImageUtil.rotateImage(bulletU, 90);
         bulletD=ImageUtil.rotateImage(bulletU, 180);


        //将爆炸图片使用for循环添加到数组中
         for (int i = 0; i < 16; i++) {
           explodes[i]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
         }
      } catch (IOException e) {
         e.printStackTrace();
      }

   }
}
