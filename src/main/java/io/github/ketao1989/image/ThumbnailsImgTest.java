package io.github.ketao1989.image;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * @author tao.ke Date: 2017/9/14 Time: 下午9:38
 */
public class ThumbnailsImgTest {

  public static void main(String[] args) throws Exception {

    BufferedImage logo = ImageIO.read(new File("/Users/ketao/demo/logo.png"));

    int logoImgWidth = logo.getWidth(null);
    int logoImgHeight = logo.getHeight(null);

    long start = System.currentTimeMillis();

    BufferedImage srcImg = ImageIO.read(new File("/Users/ketao/demo/certificate.png"));

    int srcImgWidth = srcImg.getWidth(null);
    int srcImgHeight = srcImg.getHeight(null);

    Thumbnails.Builder<BufferedImage> builder = Thumbnails.of(srcImg).scale(1.0, 1.0);

    for (int i = 0; i <= srcImgWidth / logoImgWidth; i++) {
      for (int j = 0; j <= srcImgHeight / logoImgHeight; j++) {
        builder.watermark(new MyPosition(i, j), logo, 0.1f);
      }
    }


    builder.toFile(new File("test.png"));

    System.out.println(System.currentTimeMillis() - start);
  }


  public static class MyPosition implements Position {

    private int x;
    private int y;

    public MyPosition(int x, int y) {

      this.x = x;
      this.y = y;
    }

    @Override
    public Point calculate(int enclosingWidth, int enclosingHeight, int width, int height, int insetLeft,
                           int insetRight,
                           int insetTop, int insetBottom) {
      return new Point( insetLeft + width * x, insetTop +  height * y);
    }
  }

}
