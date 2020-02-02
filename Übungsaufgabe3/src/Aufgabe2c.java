	import java.awt.Color;
	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.IOException;
	
	import javax.imageio.ImageIO;
	
	public class Aufgabe2c {
	
		public static void main(String[] args) {
			try {

				BufferedImage image = ImageIO.read(new File("blumen.bmp"));
				iterateThroughImageToGetPixel(image);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		}
		public static void iterateThroughImageToGetPixel(BufferedImage image) {
			try {
				BufferedImage cmyImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
				
				System.out.println("width, height: " + image.getWidth() + ", " + image.getHeight());
				
				for (int column = 0; column < image.getHeight(); column++) {
					for (int row = 0; row < image.getWidth(); row++) {
						System.out.println("x,y: " + row + ", " + column);
						int pixel = image.getRGB(row, column);
	//					getPixelCMYValuesFromARGBValuesPerPixel(pixel).getRGB();
						//Quelle: https://www.geeksforgeeks.org/image-processing-java-set-4-colored-image-negative-image-conversion/
						cmyImage.setRGB(row, column, getPixelCMYValuesFromARGBValuesPerPixel(pixel));
						cmyImage.s
						//Quelle: Aus der E-Mail(mit Frau Hönnemann) geschlussfolgert 
						//cmyImage.setRGB(row, column, getPixelCMYValuesFromARGBValuesPerPixel(pixel);				
						
						
						System.out.println("");
						System.out.println("----------------------------------------------------------------------------");
					}
				}
				System.out.println("#####################################################");
				ImageIO.write(cmyImage, "bmp", new File("blumen_cmy.bmp") );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Save as BMP
		}
		/*
		 * Quelle: https://alvinalexander.com/blog/post/java/getting-rgb-values-for-each-pixel-in-image-using-java-bufferedi
		 *         http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_20_006.htm#mj4c12381d5bacf8fb6ee31448d26890bb
		 */
		public static /*color*/ int getPixelCMYValuesFromARGBValuesPerPixel(int pixel) {
			int alpha = (pixel >> 24) & 0xff;
			int red = (pixel >> 16) & 0xff;
			int green = (pixel >> 8) & 0xff;
			int blue = (pixel) & 0xff;

			System.out.println("Konvert: argb: " + alpha + ", " + red + ", " + green + ", " + blue);
			
			
			
			return convertRGBToCMY(alpha, red, green, blue);
		}
		
		public static /*Color*/ int convertRGBToCMY(int alpha, int red, int green, int blue) {
			int[] cmyArray = new int[3];
			
			//cyan
			int cyan = 255 - red;
			//magenta
			int magenta = 255 - green;
			//yellow
			int yellow = 255 - blue;
			
			//Quelle:https://www.geeksforgeeks.org/image-processing-java-set-4-colored-image-negative-image-conversion/
			return (alpha<<24) | (cyan<<16) | (magenta<<8) | yellow;
			
			//Aus der E-Mail(mit Frau Hönnemann) geschlussfolgert:
			//set new RGB value 
			//return new Color(cyan, magenta, yellow);
		}
	}