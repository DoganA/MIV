package Aufgaben;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class Auf2 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnDateiOeffnen;
	private JButton btnSpeichern;
	private JFileChooser chooser;
	private String openFilename;
	private String saveFilename;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Auf2 frame = new Auf2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Auf2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnDateiOeffnen = new JButton("Datei Öffnen");
		btnDateiOeffnen.addActionListener(this);
		btnDateiOeffnen.setBounds(101, 56, 246, 30);
		contentPane.add(btnDateiOeffnen);
		
		btnSpeichern = new JButton("Speichern");
		btnSpeichern.setBounds(101, 132, 246, 25);
		contentPane.add(btnSpeichern);
		
		 // JFileChooser-Objekt erstellen
        chooser = new JFileChooser();
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
//		
//		if(src == btnDateiOeffnen) {
//			// Dialog zum Oeffnen von Dateien anzeigen
//	        chooser.showOpenDialog(null);
//		}
		if(src == btnDateiOeffnen) {
			int returnVal = chooser.showOpenDialog(null);
			System.out.println(returnVal);
		    if (returnVal == JFileChooser.APPROVE_OPTION || returnVal == JFileChooser.CANCEL_OPTION) {
		    	System.out.println("FileChoosen");
	//	        File file = chooser.getSelectedFile().getCanonicalPath();
		        try {
		        	openFilename = chooser.getSelectedFile().getCanonicalPath();
		        	System.out.println(openFilename);
		        } catch (Exception ex) {
		          System.out.println(ex.getStackTrace());
		        }
		    } 
		    else {
		        System.out.println("File access cancelled by user.");
		    }
		} else if(src == btnSpeichern) {
			JFileChooser chooserSave = new JFileChooser();
			File getSelectedDirToSave;
			File fileToSave;
			int returnVal = chooser.showSaveDialog(null);
			
			System.out.println(returnVal);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				getSelectedDirToSave = chooserSave.getCurrentDirectory();
			    fileToSave = chooserSave.getSelectedFile();
			    try {
					System.out.println("Save as file: " + getSelectedDirToSave.getCanonicalPath());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
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
//					int red = (int)(color.getRed()*0.2126);
//					int green = (int)(color.getGreen()*0.7152);
//					int blue = (int)(color.getBlue()*0.0722);
//					int zumm = red+blue+green;
//					Color gra = new Color(zumm,zumm,zumm);
					image.setRGB(x-20, i, color.getRGB());
				}
			}
			
			ImageIO.write(image, imageFormat, output);
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
