package ubung2;
import java.io.File;

public class tezt {

	public static void main(String[] args) {
		try {
		File input = new File("src\\image\\1a.bmp");
		File output = new File("src\\image\\verschiebt.bmp");
		main1.change(input,output);
		System.out.println("Im Ordner \"image\" des Projekts wurde ein Bild mit dem Namen \"verschiebt\" erstellt.");
	
		
		}catch(Exception e) { System.out.println("Belassen Sie ein Bild im Ordner \"image\" mit dem Namen \"1a\" und versuchen Sie es noch mal")   ;                        }
		
		}

}
