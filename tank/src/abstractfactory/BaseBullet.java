package abstractfactory;

import com.ruiyun.tank.Tank;

import java.awt.*;

/**
 * @Description : 文件描述
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/18 11:14
 */
public abstract class BaseBullet {
    public abstract void paint(Graphics g);
    public abstract void collidWith(Tank tf);
}
