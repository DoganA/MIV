import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


class BitmapExample {

  public static void main(String args[]) {
    BufferedImage bufImg = new BufferedImage(960, 540, BufferedImage.TYPE_INT_RGB);
    Graphics gBuf = bufImg.createGraphics();

    try {
    //Rot
    gBuf.setColor(new Color(255, 0, 0));
    gBuf.fillRect(0, 0, 960, 540);
    ImageIO.write(bufImg, "bmp", new File("Rot.bmp"));


    //grün
    gBuf.setColor(new Color(0, 255, 0));
    gBuf.fillRect(0, 0, 960, 540);
    ImageIO.write(bufImg, "bmp", new File("grün.bmp"));
    
    //Blau
    gBuf.setColor(new Color(0, 255, 255));
    gBuf.fillRect(0, 0, 960, 540);
    ImageIO.write(bufImg, "bmp", new File("blau.bmp"));

    
    //Rot-Grün
    gBuf.setColor(new Color(255, 255, 0));
    gBuf.fillRect(0, 0, 960, 540);
    ImageIO.write(bufImg, "bmp", new File("rot_grün.bmp"));
   
    //Rot-Blau
    gBuf.setColor(new Color(0, 255, 255));
    gBuf.fillRect(0, 0, 960, 540);
    ImageIO.write(bufImg, "bmp", new File("rot_blau.bmp"));


    //grün-Blau
    gBuf.setColor(new Color(0, 255, 255));
    gBuf.fillRect(0, 0, 960, 540);
    ImageIO.write(bufImg, "bmp", new File("gruen_blau.bmp"));

    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}