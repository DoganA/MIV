package Aufgaben;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Valar extends JFrame {

	private JPanel contentPane;
	private  JPanel checkpanel;
	private  JPanel panelDraw;
	private  JButton btnStart;
	private  JRadioButton rdbtnJa;
	private  JRadioButton rdbtnNein;
	private  ButtonGroup btnGrp;
	private  JLabel pointstr;
	private  point point;
	
	private  String status;
	private  String answer;
	private  int diff;
	private  int sec;
	private  int count;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Valar frame = new Valar();
//					frame.setVisible(true);
//					btnStart.addActionListener(new ActionListener() {
//						public void actionPerformed(ActionEvent e) {
//							createLightPoint();
//						}
//					});
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		new Valar().run();
	}

	/**
	 * Create the frame.
	 */
	public Valar() {
		//Variablen
		diff = 0;	//differenz zum ändern der Farbe
		sec = 0;	//zum setzen der Farbe des Punktes
		count = 0;	//zum zählen der Durchläufe
		setTitle("Aufgabe 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
//		this.setVisible(true);
		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		
		btnStart = new JButton("Start");
		btnStart.setBounds(0, 0, 434, 23);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createLightPoint();
			}
		});
		contentPane.add(btnStart);
		
			checkpanel = new JPanel();
			checkpanel.setBounds(0, 229, 434, 33);
			contentPane.add(checkpanel);
			
			rdbtnJa = new JRadioButton("Ja");
			rdbtnJa.setSelected(false);
			checkpanel.add(rdbtnJa);
			
			rdbtnNein = new JRadioButton("Nein");
			rdbtnNein.setSelected(false);
			checkpanel.add(rdbtnNein);

			btnGrp = new ButtonGroup();
			btnGrp.add(rdbtnJa);
			btnGrp.add(rdbtnNein);
		
		panelDraw = new JPanel(new BorderLayout());
		panelDraw.setForeground(Color.BLACK);
		panelDraw.setBackground(Color.BLACK);
		panelDraw.setBounds(0, 22, 434, 206);
		contentPane.add(panelDraw);
		
//		point = new point();
//		point.setVisible(false);
//		point.setAlignmentX(alignmentX);
//		point.setHorizontalAlignment(JLabel.CENTER);
//		point.setVerticalAlignment(JLabel.CENTER);
//		panelDraw.add(point, BorderLayout.CENTER);
		
		pointstr = new JLabel("X");
		pointstr.setVisible(true);
		pointstr.setForeground(Color.WHITE);
		pointstr.setHorizontalAlignment(JLabel.CENTER);
		pointstr.setVerticalAlignment(JLabel.CENTER);
		panelDraw.add(pointstr, BorderLayout.CENTER);
		
	}
	
	public void run() {
		Valar frame = new Valar();
		frame.setVisible(true);
		
		
		point = new point();
		panelDraw.add(point, BorderLayout.CENTER);
	}

//-----------------------------------------------------------------------------
	private void createLightPoint() {
//-----------------------------------------------------------------------------
		btnGrp.clearSelection();
		
		sec = sec + diff;
		//--
		checkpanel.setVisible(false);
		pointstr.setVisible(false);
		point.setForeground(new Color(sec, sec, sec));
		point.setVisible(true);
		
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		point.setVisible(false);
		pointstr.setVisible(true);
		checkpanel.setVisible(true);
		choice();
	}
//-----------------------------------------------------------------------------
	public  void choice() {
//-------------------------------------------------------------------------
		do {
			rdbtnJa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(status.equals("ueberschwellig")) {
						diff = -20;
					} else {
						sec = 255;
						diff = 0;
						status = "ueberschwellig";
					}
					answer = "JA";
				}
			});
			
			rdbtnNein.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(status.equals("ueberschwellig")) {
						sec = 0;
						diff = 0;
						status = "unterschwellig";
					} else {
						diff = 20;
					}
					answer = "NEIN";
				}
			});
			count++;
		}while(btnGrp.getSelection() == null && count >= 6);
		
		System.out.println("Light Point " + status + " " + sec + " " + answer + " " + diff);
		
		//in .txt Datei schreiben!
		createLightPoint();
	}
}
class point extends JLabel{
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    Graphics2D pointer = (Graphics2D) g;

	    pointer.setColor(Color.WHITE);
	    pointer.drawOval(0, 0, 1, 1);
//	    setSize(1, 1);
	  }
}
