package io.github.ketao1989.image;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * http://sjsky.iteye.com/blog/1154390
 * @author tao.ke Date: 2017/7/24 Time: 下午8:09
 */
public class WaterMarkImage {

  public static void waterMark(File srcImageFile,String waterMarkWord){

    try {
      Image srcImg = ImageIO.read(srcImageFile);
      int srcImgWidth = srcImg.getWidth(null);
      int srcImgHeight = srcImg.getHeight(null);
      BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);//准备设置水印效果
      Graphics2D g = bufImg.createGraphics();
      // 设置对线段的锯齿状边缘处理
      g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                         RenderingHints.VALUE_INTERPOLATION_BILINEAR);

      g.drawImage(srcImg.getScaledInstance(srcImgWidth, srcImgHeight, Image.SCALE_REPLICATE), 0, 0, null);

      // 设置水印旋转
      g.rotate(Math.toRadians(-45),
               (double) bufImg.getWidth() / 2, (double) bufImg
              .getHeight() / 2);

      g.setColor(Color.WHITE); //设置图片水印颜色

      // 设置 Font
      g.setFont(new Font("Times New Roman", Font.BOLD, 30));
      //g.setFont(wordFont);//设置水印文字字体格式

      // 字体透明效果
      float alpha = 0.5f;
      g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));

      int x = g.getFontMetrics(g.getFont()).charsWidth(waterMarkWord.toCharArray(), 0, waterMarkWord.length()) - 3;
      int y =  3;

      g.drawString(waterMarkWord, x, y);
      g.dispose();

      FileOutputStream outImgStream = new FileOutputStream("a.png");//输出图片路径
      ImageIO.write(bufImg,"png", outImgStream);
      outImgStream.flush();
      outImgStream.close();
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public static void waterMarkOther(File srcImageFile){

    try {
      BufferedImage srcImg = ImageIO.read(new File("/Users/ketao/Pictures/test_icon.jpeg"));


      Thumbnails.of(srcImageFile)
          .scale(1)
          .watermark(Positions.CENTER_LEFT, srcImg, 0.3f)
          .toFile("b.png");
    }catch (Exception e){

    }

  }

  public static void main(String[] args) {
    File in = new File("/Users/ketao/Pictures/error_log.png");
    //waterMark(in,"www.youzan.com 认证");
    waterMarkOther(in);
  }

}
