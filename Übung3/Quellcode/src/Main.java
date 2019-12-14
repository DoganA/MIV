import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Main {
	BufferedImage bufImg;
	Graphics gBuf;
	
	public static void main(String[] args) {
		
	}
	/**
	 * 
	 */
	private void createPicture() {
		//Bilddaten
		int width 	= 250;	//Breite
        int height 	= 250;	//Höhe
        int farbBit = 24;
        
		try {
			// Constructs a BufferedImage of one of the predefined image types.
	        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	 
	        // Create a graphics which can be used to draw into the buffered image
	        Graphics2D g2d = bufferedImage.createGraphics();
			
			/*
			 * lfd. Nr. | Rot | Grün | Blau |  Farben in Voller sättigung
			 *    1     |  0  |   0  |   0  |	Weiß	-
			 *    2     |  0  |   0  |   1  |	Blau	-
			 *    3     |  0  |   1  |   0  |	Grün	-
			 *    4     |  0  |   1  |   1  |	Grün-Blau
			 *    5     |  1  |   0  |   0  |	Rot	-
			 *    6     |  1  |   0  |   1  |	Rot-Blau	-
			 *    7     |  1  |   1  |   0  |	Rot-Grün	-
			 *    8     |  1  |   1  |   1  | 	Rot-Grün-Blau
			 */
			//Weiß erzeugen
	        g2d.setColor(new Color(0, 0, 0));
	        g2d.create(0, 0, width, height);
	        //g2d.fillRect(0, 0, width, height);
	        // Disposes of this graphics context and releases any system resources that it is using. 
	        g2d.dispose();
	 
	        // Save as BMP
	        File file = new File("myimage.png");
	        ImageIO.write(bufferedImage, "bmp", new File("myimage.png"));
	        
			
			//gBuf.setColor(new Color(red, green, blue));
			
//			//Rot erzeugen
//			gBuf.setColor(new Color(255, 0, 0));
//			ImageIO.write(gBuf, "bmp", new File("../Rot.bmp"));
//			//Rot-Grün erzeugen
//			gBuf.setColor(new Color(255, 255, 0));
//			ImageIO.write(gBuf, "bmp", new File("../Rot_Grün.bmp"));
//			//Rot-Blau erzeugen
//			gBuf.setColor(new Color(255, 0, 255));
//			ImageIO.write(gBuf, "bmp", new File("../Rot_Blau.bmp"));
//			
//			//Grün erzeugen
//			gBuf.setColor(new Color(0, 255, 0));
//			ImageIO.write(gBuf, "bmp", new File("../Grün.bmp"));
//			
//			//Grün-Blau erzeugen
//			gBuf.setColor(new Color(0, 255, 255));
//			ImageIO.write(gBuf, "bmp", new File("../Grün_Blau.bmp"));
//			
//			//Blau erzeugen
//			gBuf.setColor(new Color(0, 0, 255));
//			ImageIO.write(gBuf, "bmp", new File("../Blau.bmp"));
//			
//			//Rot-Grün-Blau erzeugen
//			gBuf.setColor(new Color(255, 255, 255));
//			ImageIO.write(gBuf, "bmp", new File("../Rot_Grün_Blau.bmp"));
			
		} catch (IOException e) {
			System.out.println("Exception occured :" + e.getMessage());
		}
	}

}
