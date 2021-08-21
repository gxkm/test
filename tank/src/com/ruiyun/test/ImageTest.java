package com.ruiyun.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description : 文件描述
 * @ProjectName : JavaSenior
 * @Author : Jack.Wong
 * @Time : 2021/8/14 15:25
 */
public class ImageTest {
    @Test
    void test(){
        try {
         BufferedImage image = ImageIO.read(new File("D:/intelijPoject/JavaSenior/tank/src/images/bulletD.gif"));
       assertNotNull(image);

          BufferedImage image1 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
         //   InputStream resourceAsStream = ImageTest.class.getClassLoader().getResourceAsStream("images/bulletL.gif");
       //     System.out.println(resourceAsStream.toString());

           // assertNotNull(image1);
            BufferedImage image2 = ImageIO.read(ImageTest.class.getResourceAsStream("/images/bulletL.gif"));
            assertNotNull(image2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
