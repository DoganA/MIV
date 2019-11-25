package test;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFrame;

import test.main1;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class main {

	private JFrame frmUbung;
    String link = new String();
    private JTextField link1;
	/**
	 * Launch the application.
	 */
    
    

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frmUbung.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		
		
		
			
			
		
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUbung = new JFrame();
		frmUbung.setTitle("Ubung 2");
		frmUbung.setBounds(100, 100, 450, 300);
		frmUbung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUbung.getContentPane().setLayout(null);
		
		link1 = new JTextField();
		link1.setBounds(10, 121, 414, 20);
		frmUbung.getContentPane().add(link1);
		link1.setColumns(10);
		
		JButton b1 = new JButton("Verschieben");
		b1.setFont(new Font("Tahoma", Font.BOLD, 16));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					link = link1.getText();
					File input = new File(link);
					File output = new File("src\\image\\done.bmp");
					main1.Verschieben(input,output);
					System.out.println("Finden Sie Ihre Image im Ordner \"image\" des Projekts mit dem Namen \"done\" erstellt.");
				
				}catch(Exception ex) { System.out.println(link)   ;                        }
				
			}
		});
		b1.setBounds(65, 162, 315, 23);
		frmUbung.getContentPane().add(b1);
		
		JLabel lblGebenSieBitte = new JLabel("Geben Sie bitte das Link des Bilds ein. ");
		lblGebenSieBitte.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGebenSieBitte.setHorizontalAlignment(SwingConstants.CENTER);
		lblGebenSieBitte.setBounds(25, 31, 388, 37);
		frmUbung.getContentPane().add(lblGebenSieBitte);
		
		JLabel lblNewLabel = new JLabel("bitte nicht vergessen Der Typ des Bilds u geben. ZB: ...../..../image.BMP");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(50, 91, 363, 14);
		frmUbung.getContentPane().add(lblNewLabel);
	}
}
