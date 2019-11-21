package Aufgaben;
/**
 * @author Dogan Alkan, Matrikelnummer: 835118
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class dsa extends JPanel implements ActionListener {
	
	private JPanel checkPanel = new JPanel();
	private JRadioButton rdbtnJa = new JRadioButton("Ja");
	private JRadioButton rdbtnNein = new JRadioButton("Nein");
	private ButtonGroup btnGroup = new ButtonGroup();
	
    private Timer timer = null;
    private JButton btnStart = new JButton("Start");
    private JLabel labelX = new JLabel("X");
    private Point point = new Point();
	private String answer = new String();
	private String status = null;
	private int diff = 0;
	private int sec;
	private int count = 0;
	
	/**
	 * 
     * @param width Breite des JPanels
     * @param height Höhe des JPanels
	 */
    public dsa(int width, int height) {
        setLayout(null);
        setBackground(Color.BLACK);
        btnStart.setPreferredSize(new Dimension(width/4, btnStart.getFont().getSize()*2));

        labelX.setHorizontalAlignment(JLabel.CENTER);
        labelX.setForeground(Color.WHITE);
        
			btnGroup = new ButtonGroup();
			
			rdbtnJa.addActionListener(this);
			checkPanel.add(rdbtnJa);
			btnGroup.add(rdbtnJa);
			
			rdbtnNein.addActionListener(this);
			checkPanel.add(rdbtnNein);
			btnGroup.add(rdbtnNein);

            checkPanel.setVisible(false);
		
        add(labelX);
        add(btnStart);
		add(checkPanel);
        btnStart.addActionListener(this);
        updateSize(width, height);
    }
    /**
     * Dient als Startpunkt, nach dem drücken des Start Buttons wird diese Funktion,
     * als ersten und nur einamlig, ausgeführt.
     */
    public void run() {
    	if(status == null) {
        	// create random object
            Random randomno = new Random();
            // get next next boolean value 
            boolean chooseState = randomno.nextBoolean();
            //
            
            if(new Random().nextBoolean()) {
            	status = new String("ueberschwellig");
            } else if(!chooseState) {
            	status = new String("unterschwellig");
            }
        	getStateStartingPoint();
    	}
    }
    
    /**
     * Wählt einen Startpunkt für den nächsten Durchlauf aus.
     */
    public void getStateStartingPoint() {
    	if(status.equals("ueberschwellig")) {
        	int[] startingPointUeberschwelig = {255, 200, 150, 115, 100, 80};
			sec = startingPointUeberschwelig[new Random().nextInt(6)];
		} else if(status.equals("unterschwellig")) {
	    	int[] startingPoinUnterschwaelig = {0, 10, 15, 30, 45, 60};
			sec =  startingPoinUnterschwaelig[new Random().nextInt(6)];
		}
		count++;
    }

    /**
     * Receives messages from button start and point's timer.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    	boolean isStatusChanged = false;
    	int delay = 300;

	    Object src = e.getSource();
		if(count < 7) {
		    //---------------------------------------------------------------------
		    if (src == btnStart) {
		        run();
		        showPoint(delay);
		        btnStart.setVisible(false);
		        checkPanel.setVisible(true);
		    //---------------------------------------------------------------------
		    } else if (src == timer && isStatusChanged == false) {
		        showX();
		    //---------------------------------------------------------------------
		    } else if (src == rdbtnJa) {
		    	if(status.equals("ueberschwellig")) {
		    		if(sec >=20) {
						diff = -20;		    			
		    		} else {
		    			diff =0;
		    		}
					
					isStatusChanged = false;
				} else {
					sec = 255;
					diff = 0;
					status = "ueberschwellig";
		
					isStatusChanged = true;
				}
				answer = "JA";
		    	showPoint(delay);
		    //---------------------------------------------------------------------
		    } else if (src == rdbtnNein) {
		    	if(status.equals("ueberschwellig")) {
					sec = 0;
					diff = 0;
					status = "unterschwellig";
		
					isStatusChanged = true;
				} else {
					diff = 20;
					
					isStatusChanged = false;
				}
				answer = "NEIN";
		    	showPoint(delay);
		    }
		    System.out.println("Light Point status: " + status + " sec: " + sec + " answer: " + answer + " diff: " + diff + " count: " + count);
		    
		    if(isStatusChanged) {
		    	getStateStartingPoint();
		    	isStatusChanged = false;
		    }
		} else {
			if(timer.isRunning()) {
				timer.stop();
			}
			timer = null;
			checkPanel.setVisible(false);
		}
    }
    
    /**
     * Zeichnet einen Punkt auf den JPanel. 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int pointSize = 2;	//Wenn die grösse 1 ist, ist der Punkt nicht mehr sichtbar

        if (!labelX.isVisible()) {
            g.setColor(new Color(sec, sec, sec));
            g.fillOval(point.x, point.y, pointSize, pointSize);
        }
    }

    /**
     * Setzt lableX auf unsichtbar und startet einen timer welches 
     * {@link #actionPerformed(ActionEvent)} nach einer bestimmten Zeit aufruft.
     *
     * @param duration
     */
    private void showPoint(int duration) {
    	sec = sec + diff;
    	
    	checkPanel.setVisible(false);
        labelX.setVisible(false);
        
        timer = new Timer(duration, this);
        timer.start();
    }

    /**
     * Stopt den Timer welches durch {@link #showPoint(int)} aktiviert wurde und
     * setzt labelX auf sichtbar.
     */
    private void showX() {
    	btnGroup.clearSelection();
        if (timer != null) {
            timer.stop();
        }
        timer = null;
        
        labelX.setVisible(true);
        checkPanel.setVisible(true);
    }
    /**
     * Setzt die grössen und propotionen der GUI.
     * @param width Breite des JPanels
     * @param height Höhe des JPanels
     */
    private void updateSize(int width, int height) {
        int dimX = (int) (btnStart.getFont().getSize() * 2);
        labelX.setBounds((width - dimX) / 2, (height - dimX) / 2, dimX, dimX);
        int startWidth = width / 5;
        
        btnStart.setBounds(0, 0, width, 23);
        point.x = width / 2;
        point.y = height / 2;
        
		checkPanel.setBounds(0, height-33, width, 33);

        setPreferredSize(new Dimension(width, height));

    }
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Aufgabe 1");
        frame.add(new Aufgabe1(700, 300));
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
//05.11.2019 18:23 Kareem Wegner