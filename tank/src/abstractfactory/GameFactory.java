package abstractfactory;

import com.ruiyun.tank.Dir;
import com.ruiyun.tank.GameModel;
import com.ruiyun.tank.Group;
import com.ruiyun.tank.TankFrame;

/**
 * @Description : 文件描述
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/18 11:08
 */
public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, GameModel gm);
    public abstract BaseExplode createExplode(int x, int y, GameModel gm);
    public abstract BaseBullet createBullet(int x,int y , Dir dir, Group group,GameModel gm);
}
