import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Aufgabe2c {
    public static void main(String[] args) {
        try {
            BufferedImage image = ImageIO.read(new File("blumen.bmp"));
            iterateThroughImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void iterateThroughImage(BufferedImage image) {
        int w = image.getWidth();
        int h = image.getHeight();

        System.out.println("width, height: " + w + ", " + h);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.println("x,y: " + j + ", " + i);
                int pixel = image.getRGB(j, i);
                getPixelARGB(pixel);
                System.out.println("");
            }
        }
    }
    public static void getPixelARGB(int pixel) {
        int alpha = (pixel >> 24) & 0xff;
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
    }
    public static void convertRGBToCMY(int red, int green, int blue) {
        int cyan = 255 - red;
        int magenta =  255 - green;
        int yellow =  255 - blue;
        System.out.println("argb: "+ red + ", " + green + ", " + blue);
        
        BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        ImageIO.write(buffImg, "bmp", new File("./img/7_rot_grün_blau.bmp") ); // Save as BMP	
        
    }
}
