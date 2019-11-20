package Aufgaben;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Aufgabe1_old extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel checkPanel;
	private JPanel pointPanel;
	
	private JRadioButton rdbtnJa;
	private JRadioButton rdbtnNein;
	private ButtonGroup btnGroup;
	
	private JButton btnStart;
	private JLabel pointstr;
	private drawPoint point;
	
	private String status;
	private String answer;
	private int diff;
	private int sec;
	private int count;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aufgabe1_old frame = new Aufgabe1_old();
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
	public Aufgabe1_old() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnStart = new JButton("Start");
		btnStart.setBounds(0, 0, 684, 23);
		contentPane.add(btnStart);
		
			checkPanel = new JPanel();
			checkPanel.setBounds(0, 229, 684, 33);
			checkPanel.setVisible(false);;
			contentPane.add(checkPanel);

			btnGroup = new ButtonGroup();
			
			rdbtnJa = new JRadioButton("Ja");
			rdbtnJa.setActionCommand("RadioButton_Ja");
			rdbtnJa.addActionListener(this);
			checkPanel.add(rdbtnJa);
			btnGroup.add(rdbtnJa);
			
			rdbtnNein = new JRadioButton("Nein");
			rdbtnNein.setActionCommand("RadioButton_Nein");
			rdbtnNein.addActionListener(this);
			checkPanel.add(rdbtnNein);
			btnGroup.add(rdbtnNein);
			
		pointPanel = new JPanel(new BorderLayout());
		pointPanel.setBackground(Color.BLACK);
		pointPanel.setBounds(0, 23, 684, 209);
		contentPane.add(pointPanel);
		
		pointstr = new JLabel("X");
		pointstr.setForeground(Color.WHITE);
		pointstr.setVerticalAlignment(JLabel.CENTER);
		pointstr.setHorizontalAlignment(JLabel.CENTER);
		pointPanel.add(pointstr, BorderLayout.CENTER);
		
		point = new drawPoint();
		point.setBackground(new Color(sec,sec,sec));
		point.setPreferredSize(new Dimension(700, 300));
		pointPanel.add(point, BorderLayout.CENTER);
		point.setVisible(false);
		
		answer = new String();
		status = new String();
		diff = 0;
		sec = 0;
		count = 0;
		run();
	}
	
	public void run() {
		System.out.println("-----------------");
		System.out.println("run() Method");
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createLightPoint();
				
				btnStart.setEnabled(false);
				btnStart.setVisible(false);
				
				pointPanel.setBounds(0, 0, 684, 242);
				
				System.out.println("Start Button ActionPerformed");
			}
		});
		
		System.out.println("End run() Method");
	}
	

    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
        // draw point only if labelX is not visible
        if (!pointstr.isVisible()) {
//            g.setColor(color);
            g.setColor(new Color(sec, sec, sec));
            g.fillOval(pointPanel.getWidth()/2, pointPanel.getHeight()/2, 2, 2);
        }
    }
//	private void createLightPoint() {
//		System.out.println("-----------------");
//		System.out.println("Enter createLightPoint()");
//		
//		btnGroup.clearSelection();
//		lblX.setVisible(false);
//		lblX.repaint();
//		checkPanel.setVisible(false);
//		//point.setForeground(new Color(ec,sec,sec));
//		//point.setVisible(true);
//		
//		System.out.println("Bevor Sleep");
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("After Sleep");
////		point.setVisible(false);
//		lblX.setVisible(true);
//		checkPanel.setVisible(true);
//	}
	private void createLightPoint() {
		System.out.println("-----------------");
		System.out.println("Enter createLightPoint()");
        btnGroup.clearSelection();
        
        setVisibility(true);

		
        Thread th = new Thread(new Runnable() {
            public void run() {
                try { Thread.sleep(2000); } catch (InterruptedException ex) {}
                setVisibility(false);
            }
        });
        th.start();
	}
	private void setVisibility(final boolean value) {
	    if (SwingUtilities.isEventDispatchThread()) {
	    	point.setForeground(new Color(sec,sec,sec));
	        pointstr.setVisible(!value);
	        checkPanel.setVisible(!value);
//	    	point.setVisible(value);
	    } else {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() { setVisibility(value); }
	        });
	    }
	}
	class drawPoint extends JLabel {
		@Override
		public void paintComponent(Graphics g) {
			if(!pointstr.isVisible()) {
				System.out.println("############################");
				System.out.println("drawPoint - paintComponent()");
			    super.paintComponent(g);
	
			    Graphics2D pointer = (Graphics2D) g;
	
			    pointer.setColor(Color.WHITE);
			    pointer.fillOval(pointPanel.getWidth()/2, pointPanel.getHeight()/2, 2, 2);
	//		    setSize(1, 1);
			}
		  }
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("-----------------");
		System.out.println("Enter actionPerformed()");
		if((ae.getActionCommand().equals("RadioButton_Ja") || ae.getActionCommand().equals("RadioButton_Nein")) && count <= 6) {
			if(ae.getActionCommand().equals("RadioButton_Ja")) {
				System.out.println("RadioButton_Ja");
				if(status.equals("ueberschwellig")) {
					diff = -20;
				} else {
					sec = 255;
					diff = 0;
					status = "ueberschwellig";
				}
				answer = "JA";
				
			} else if(ae.getActionCommand().equals("RadioButton_Nein")) {
				System.out.println("RadioButton_Nein");
				if(status.equals("ueberschwellig")) {
					sec = 0;
					diff = 0;
					status = "unterschwellig";
				} else {
					diff = 20;
				}
				answer = "NEIN";
			}
		}
		
		System.out.println("Light Point. status: " + status + " sec: " + sec + " answer: " + answer + " diff: " + diff);
		
		//in .txt Datei schreiben!
		createLightPoint();
	}
}
