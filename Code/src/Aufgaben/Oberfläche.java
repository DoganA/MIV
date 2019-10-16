package Aufgaben;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Color;

public class Oberfläche extends JFrame implements ActionListener, ItemListener{

	private JPanel contentPane;
	private JButton btnStart;
	private JRadioButton rdbtnJa;
	private JRadioButton rdbtnNein;
	private ButtonGroup btnGrp;
	private String status;
	private String answer;
	private int diff;
	private int sec;
	private Point point;
	private Label pointstr;
	private asd checkpanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public Oberfläche() {
		this.setTitle("Aufgabe1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Create Start Button, to start whole event
		btnStart = new JButton("Start");
		btnStart.setBounds(0, 0, 786, 21);
		btnStart.addActionListener(this);
		btnStart.setVisible(true);
		btnStart.setActionCommand("StartButtonPresses");
		contentPane.add(btnStart);
		
		//Radio buttons
		rdbtnJa = new JRadioButton("Ja");
		rdbtnJa.setBounds(126, 336, 43, 21);
		rdbtnJa.setSelected(false);
		//contentPane.add(rdbtnJa);
		
		rdbtnNein = new JRadioButton("Nein");
		rdbtnNein.setBounds(171, 336, 47, 21);
		rdbtnNein.setSelected(false);
		//contentPane.add(rdbtnNein);
		btnGrp = new ButtonGroup();
		btnGrp.add(rdbtnJa);
		btnGrp.add(rdbtnNein);
		contentPane.add(rdbtnJa);
		contentPane.add(rdbtnNein);
		//contentPane.add(btnGrp);
		
		diff = 0;
		sec = 0;
	}
	
	private void createLightPoint() {
		btnGrp.clearSelection();
		
		sec = sec + diff;
		//--
		checkpanel.setVivible(false);
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
	public void choice() {
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
		}while(btnGrp.getSelection() == null);
		
		System.out.println("Light Point " + status + " " + sec + " " + answer + " " + diff);
		
		//in .txt Datei schreiben!
		createLightPoint();
	}
}
