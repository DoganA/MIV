package test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class main1 {
	
	public static void Verschieben(File in,File out) {
			try {
				ImageInputStream call = ImageIO.createImageInputStream(in);
				Iterator<ImageReader> imageitera = ImageIO.getImageReaders(call);
				ImageReader reader  = imageitera.next();
				String IF = reader.getFormatName();
				BufferedImage Bild = ImageIO.read(call);
					int width = Bild.getWidth();
					int height = Bild.getHeight();
						for (int i =0;i < height; i++) {
							for(int x=20;x<width;x++) {
									Color color = new Color(Bild.getRGB(x, i));
					
									Bild.setRGB(x-20, i, color.getRGB());
								}
							}
			
								ImageIO.write(Bild,IF,out);
				}
					catch(IOException ex) {
						ex.printStackTrace();
					}
			
		}

}
