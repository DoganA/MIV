package ubung2;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class main1 {
	
	public static void change(File input,File output) {
		try {
			ImageInputStream itt = ImageIO.createImageInputStream(input);
			Iterator<ImageReader> iterator = ImageIO.getImageReaders(itt);
			ImageReader reader  = iterator.next();
			String imageFormat = reader.getFormatName();
			BufferedImage image = ImageIO.read(itt);
			int width = image.getWidth();
			int height = image.getHeight();
			for (int i =0;i < height; i++) {
				for(int x=21;x<width;x++) {
					Color color = new Color(image.getRGB(x, i));
					int red = (int)(color.getRed()*0.2126);
					int green = (int)(color.getGreen()*0.7152);
					int blue = (int)(color.getBlue()*0.0722);
					int zumm = red+blue+green;
					Color gra = new Color(zumm,zumm,zumm);
					image.setRGB(x-20, i, color.getRGB());
				}
			}
			
			ImageIO.write(image,imageFormat,output);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
			
			
		
		
		
	}

}
