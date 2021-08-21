package abstractfactory;

import com.ruiyun.tank.*;

/**
 * @Description : 文件描述
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/18 11:14
 */
public class DefaultFactory extends GameFactory{


    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, GameModel gm) {
        return null;
    }

    @Override
    public BaseExplode createExplode(int x, int y, GameModel gm) {
        return new Explode(x, y, gm);
    }

    @Override
    public BaseBullet createBullet(int x, int y,  Dir dir, Group group,GameModel gm) {
        return new Bullet(x,y,dir,group,gm);
    }
}
