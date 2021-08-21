package abstractfactory;

import com.ruiyun.tank.*;

import java.awt.*;

/**
 * @Description : 子弹对象
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/13 16:08
 */
public class RectBullet extends BaseBullet {
    //子弹速度
    private static final int SPEED = PropertyMgr.get("bulletSpeed");
    //根据ResourceMgr的图片获取宽 高
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    //创建一个矩形
    Rectangle rect=new Rectangle();


    //子弹坐标
    private int x, y;
    //子弹方向
    private Dir dir;

    //解决子弹出边界后，把子弹成活度设置为false ，打出后没有出边界，就活着就设置为true
    public boolean living = true;

    //TankFrame的引用
    GameModel gm;

    //子弹也归类，默认为BAD
    private Group group=Group.BAD;

    //这里也需要持有TankFrame的引用
    public RectBullet(int x, int y, Dir dir, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group=group;
        this.gm = gm;

        rect.x=this.x;
        rect.y=this.y;
        rect.width=WIDTH;
        rect.height=HEIGHT;
        //在构造器里面，直接把对象加到bullets容器里面去
        gm.bullets.add(this);
    }

    public void paint(Graphics g) {
        if (!living) {
          gm.bullets.remove(this);
        }
        Color c=g.getColor();
        g.setColor(Color.GREEN);
        g.fillRect(x,y,20,20);
        g.setColor(c);

//        switch (dir) {
//            case LEFT:
//                g.drawImage(ResourceMgr.bulletL, x, y, null);
//                break;
//            case RIGHT:
//                g.drawImage(ResourceMgr.bulletR, x, y, null);
//                break;
//            case UP:
//                g.drawImage(ResourceMgr.bulletU, x, y, null);
//                break;
//            case DOWN:
//                g.drawImage(ResourceMgr.bulletD, x, y, null);
//                break;
//        }

//        //获取Graphics画笔的原来颜色
//        Color c = g.getColor();
//        g.setColor(Color.GREEN);
//        //Graphics画一个圆
//        g.fillOval(x, y, WIDTH, HEIGHT);
//        //再把Graphics画笔还原原来的颜色
//        g.setColor(c);
        move();
    }

    //判断方向
    private void move() {


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

        //判断子弹是否越界，越界就把live设置为false
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }

    //检测子弹与坦克的相交，使用辅助类Rectangle
    public void collidWith(Tank tank) {
        //判断子弹与坦克是否是一个group
        if (this.group==tank.getGroup()) return;
        //TODO:用一个rect来记录子弹的位置

        //判断两个方块是否相交
        if (rect.intersects(tank.rect)) {
            tank.die();
            this.die();
            //计算爆炸的位置
            int eX=tank.getX()+Tank.WIDTH/2-Explode.WIDTH/2;
            int eY=tank.getY()+Tank.HEIGHT/2-Explode.HEIGHT/2;
           // tf.explodes.add(new Explode(eX, eY, tf));
            //使用抽象工厂批量生产Explode
            gm.explodes.add(new Explode(eX, eY, gm));
        }
    }

    //子弹的live属性设置为false
    private void die() {
        this.living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
