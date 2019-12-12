import java.awt.Color;
import java.awt.Graphics;
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
		try {
			Color col = new Color();
			bufImg = new BufferedImage(960, 560,BufferedImage.TYPE_INT_RGB);
			gBuf = bufImg.createGraphics();
			gBuf.setColor(col.BLUE);
			ImageIO.write(gBuf, "bmp", new File("C://Users/Rou/Desktop/image.bmp"));
		} catch (IOException e) {
			System.out.println("Exception occured :" + e.getMessage());
		}
	}

}
