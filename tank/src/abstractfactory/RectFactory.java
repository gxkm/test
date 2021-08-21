package abstractfactory;

import com.ruiyun.tank.Dir;
import com.ruiyun.tank.GameModel;
import com.ruiyun.tank.Group;
import com.ruiyun.tank.TankFrame;

/**
 * @Description : 文件描述
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/18 12:14
 */
public class RectFactory extends GameFactory{
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, GameModel gm) {
        return null;
    }

    @Override
    public BaseExplode createExplode(int x, int y,GameModel gm) {
        return new RectExplode(x, y, gm);
    }

    @Override
    public BaseBullet createBullet(int x, int y,  Dir dir, Group group,GameModel gm) {
        return new RectBullet(x,y,dir,group,gm);
    }
}
