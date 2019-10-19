package Aufgaben;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.geom.Point2D;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Oberfläche extends JFrame{

	private JPanel contentPane;
	private JButton btnStart;
	private JRadioButton rdbtnJa;
	private JRadioButton rdbtnNein;
	private ButtonGroup btnGrp;
	private String status;
	private String answer;
	private int diff;
	private int sec;
//	private Point point;
	private int count;
	private asd point;
	private JPanel checkpanel;
	private JLabel pointstr;
	
	

	/**
	 * Create the frame.
	 */
//-----------------------------------------------------------------------------
	public Oberfläche() {
//-----------------------------------------------------------------------------
		this.setTitle("Aufgabe1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Create Start Button, to start whole event
		btnStart = new JButton("Start");
		btnStart.setBounds(0, 0, 786, 21);
//		btnStart.addActionListener(this);
		btnStart.setVisible(true);
		btnStart.setActionCommand("StartButtonPresses");
		contentPane.add(btnStart);
		
		//Radio buttons
		rdbtnJa = new JRadioButton("Ja");
		rdbtnJa.setBounds(349, 5, 35, 21);
		rdbtnJa.setSelected(false);
		//contentPane.add(rdbtnJa);
		
		rdbtnNein = new JRadioButton("Nein");
		rdbtnNein.setBounds(389, 5, 47, 21);
		rdbtnNein.setSelected(false);
		//contentPane.add(rdbtnNein);
		btnGrp = new ButtonGroup();
		btnGrp.add(rdbtnJa);
		btnGrp.add(rdbtnNein);
		
		checkpanel = new JPanel();
		checkpanel.setBounds(0, 336, 786, 27);
		contentPane.add(checkpanel);
		checkpanel.add(rdbtnJa, CENTER_ALIGNMENT);
		checkpanel.add(rdbtnNein, CENTER_ALIGNMENT);
		
		pointstr = new JLabel("X");
		pointstr.setForeground(Color.WHITE);
		//pointstr.setBounds(294, 192, 6, 13);
		contentPane.add(pointstr);
		//contentPane.add(btnGrp);
		
		//Variablen
		diff = 0;	//differenz zum ändern der Farbe
		sec = 0;	//zum setzen der Farbe des Punktes
		count = 0;	//zum zählen der Durchläufe
	}
//-----------------------------------------------------------------------------
	private void run() {
//-----------------------------------------------------------------------------
		// Start button
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
//-----------------------------------------------------------------------------
	private void createLightPoint() {
//-----------------------------------------------------------------------------
		btnGrp.clearSelection();
		
		sec = sec + diff;
		//--
		checkpanel.setVisible(false);
		pointstr.setVisible(false);
		point.setforeground(new Color(sec, sec, sec));
		point.setVisible(true);
		
		try {
			Thread.sleep(20000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		point.setVisible(false);
		pointstr.setVisible(true);
		checkpanel.setVisible(true);
		choice();
	}
//-----------------------------------------------------------------------------
	public void choice() {
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
//-----------------------------------------------------------------------------
	public static void main(String[] args) {
//-----------------------------------------------------------------------------
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Oberfläche frame = new Oberfläche();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
