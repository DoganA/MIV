import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Aufgabe2 {
	
	public static void main(String[] args) {
		createPicture();
	}
	/**
	 * Speichert ein erstelltes Bild ab. 
	 */
	private static void createPicture() {
		//Variablen für
		int width 	= 960;	//Breite des Bildes
        int height 	= 540;	//Höhe des Bildes

        try {
			/* Folgede Tabelle zeigt, welche Möglichgeiten es gibt,
			 * für die jeweiligen zusammensetzung der Farben jeweiligen Farben.
			 * Eine 0 unter der Bezeichnung einer farbe besagt, dass die jeweilige Farbe nicht gesetzt wird.
			 * Eine 1, dass es gesetzt wir. Setzet bedeutet im Kontext der Aufgabe, dass die Farbe in vollsätigung,
			 * also mit dem RGB Wert 255 gesäzt wird. Dadurch ergeben rund 8 Mögliche Farben. Wobei eine Weiss und eine Schwarz ist.
			 * lfd. Nr. | Rot | Grün | Blau |  Farben in Voller sättigung
			 *    1     |  0  |   0  |   0  |	Schwarz
			 *    2     |  0  |   0  |   1  |	Blau
			 *    3     |  0  |   1  |   0  |	Grün
			 *    4     |  0  |   1  |   1  |	Grün-Blau	(cyan1)
			 *    5     |  1  |   0  |   0  |	Rot
			 *    6     |  1  |   0  |   1  |	Rot-Blau	(magenta)
			 *    7     |  1  |   1  |   0  |	Rot-Grün	(Blau)
			 *    8     |  1  |   1  |   1  | 	Rot-Grün-Blau (Weiß)
			 */;
			//Schwarz erzeugen
	        ImageIO.write(setColorToPixelInBufferedImage(width, height, new Color(0, 0, 0)),
	        			  "bmp",
	        			  new File("./img/1_schwarz.bmp") ); // Save as BMP
			
	        //Blau erzeugen
	        ImageIO.write(setColorToPixelInBufferedImage(width, height, new Color(0, 0, 255)),
	        		"bmp",
	        		new File("./img/2_blau.bmp") ); // Save as BMP
	        
	        //Grün erzeugen
	        ImageIO.write(setColorToPixelInBufferedImage(width, height, new Color(0, 255, 0)),
	        		"bmp",
	        		new File("./img/3_grün.bmp") ); // Save as BMP

	        //Rot erzeugen
	        ImageIO.write(setColorToPixelInBufferedImage(width, height, new Color(255, 0, 0)),
	        		"bmp",
	        		new File("./img/4_rot.bmp") ); // Save as BMP
	        
	        //Rot-Blau erzeugen
	        ImageIO.write(setColorToPixelInBufferedImage(width, height, new Color(255, 0, 255)),
	        		"bmp",
	        		new File("./img/5_rot_blau.bmp") ); // Save as BMP
	        
	        //Rot-Grün erzeugen
	        ImageIO.write(setColorToPixelInBufferedImage(width, height, new Color(255, 255, 0)),
	        		"bmp",
	        		new File("./img/6_rot_grün.bmp") ); // Save as BMP
	        
	        //Rot-Grün-Blau(Weiß) erzeugen
	        ImageIO.write(setColorToPixelInBufferedImage(width, height, new Color(255, 255, 255)),
	        		"bmp",
	        		new File("./img/7_rot_grün_blau.bmp") ); // Save as BMP			
		} catch (IOException e) {
			System.out.println("Exception occured :" + e.getMessage());
		}
	}
	/**
	 * Erzeugt ein Bild mit der angegeben Größe und setzt diese auf eine gewünschte Farbe.
	 * @param width		Breite des gewünschten Bildes
	 * @param height	Höhe des gewünschten Bildes
	 * @param col		Farbe mit dessen hilfe das Bildegesetzt werden soll.
	 * @return			Erzeugtes Bild.
	 */
	public static BufferedImage setColorToPixelInBufferedImage(int width, int height, Color col) {
        //Constructs a BufferedImage of one of the predefined image types.
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		
		for(int x= 0; x<width; x++)
        {
            for(int y= 0; y<height; y++)
            {
                image.setRGB(x, y, col.getRGB());
            }
        }
		return image;
	}

}
