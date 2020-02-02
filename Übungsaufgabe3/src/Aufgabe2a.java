import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Aufgabe2a {
	public static void main(String[] args) {
		createPicture();
	}
	/**
	 * Speichert ein erstelltes Bild ab. 
	 */
	private static void createPicture() {
		//Variablen f�r
		int width 	= 960;	//Breite des Bildes
        int height 	= 540;	//H�he des Bildes

        try {
			/* Folgede Tabelle zeigt, welche M�glichgeiten es gibt,
			 * f�r die jeweiligen zusammensetzung der jeweiligen Farben.
			 * Eine 0 unter der Bezeichnung einer farbe besagt, dass die jeweilige Farbe nicht gesetzt wird.
			 * Eine 1, dass es gesetzt wir. Setzet bedeutet im Kontext der Aufgabe, dass die Farbe in volls�tigung,
			 * also mit dem Wert 255 ges�zt wird. Dadurch ergeben rund 8 M�gliche Farben. Wobei eine Weiss und eine Schwarz ist.
			 * lfd. Nr. | Rot | Gr�n | Blau |  Farben in Voller s�ttigung
			 *    1     |  0  |   0  |   0  |	Schwarz
			 *    2     |  0  |   0  |   1  |	Blau
			 *    3     |  0  |   1  |   0  |	Gr�n
			 *    4     |  0  |   1  |   1  |	Gr�n-Blau	(cyan1)
			 *    5     |  1  |   0  |   0  |	Rot
			 *    6     |  1  |   0  |   1  |	Rot-Blau	(magenta)
			 *    7     |  1  |   1  |   0  |	Rot-Gr�n	(Blau)
			 *    8     |  1  |   1  |   1  | 	Rot-Gr�n-Blau (Wei�)
			 */;
			//Schwarz erzeugen
	        ImageIO.write(setColorToPixelInBufferedImage(width, height, new Color(0, 0, 0)),
	        			  "bmp",
	        			  new File("1_schwarz.bmp") ); // Save as BMP
			
	        //Blau erzeugen
	        ImageIO.write(setColorToPixelInBufferedImage(width, height, new Color(0, 0, 255)),
	        		"bmp",
	        		new File("2_blau.bmp") ); // Save as BMP
	        
	        //Gr�n erzeugen
	        ImageIO.write(setColorToPixelInBufferedImage(width, height, new Color(0, 255, 0)),
	        		"bmp",
	        		new File("3_grün.bmp") ); // Save as BMP

	        //Rot erzeugen
	        ImageIO.write(setColorToPixelInBufferedImage(width, height, new Color(255, 0, 0)),
	        		"bmp",
	        		new File("4_rot.bmp") ); // Save as BMP
	        
	        //Rot-Blau erzeugen
	        ImageIO.write(setColorToPixelInBufferedImage(width, height, new Color(255, 0, 255)),
	        		"bmp",
	        		new File("5_rot_blau.bmp") ); // Save as BMP
	        
	        //Rot-Gr�n erzeugen
	        ImageIO.write(setColorToPixelInBufferedImage(width, height, new Color(255, 255, 0)),
	        		"bmp",
	        		new File("6_rot_grün.bmp") ); // Save as BMP
	        
	        //Rot-Gr�n-Blau(Weiß) erzeugen
	        ImageIO.write(setColorToPixelInBufferedImage(width, height, new Color(255, 255, 255)),
	        		"bmp",
	        		new File("7_rot_grün_blau.bmp") ); // Save as BMP			
		} catch (IOException e) {
			System.out.println("Exception occured :" + e.getMessage());
		}
	}
	/**
	 * Erzeugt ein Bild mit der angegeben Größe und setzt diese auf eine gew�nschte Farbe.
	 * @param width		Breite des gewünschten Bildes
	 * @param height	Höhe des gewünschten Bildes
	 * @param col		Farbe mit dessen hilfe das Bildegesetzt werden soll.
	 * @return			Erzeugtes Bild.
	 */
	public static BufferedImage setColorToPixelInBufferedImage(int width, int height, Color col) {
        //Constructs a BufferedImage of one of the predefined image types.
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
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
