/**
 * @author Dogan Alkan, s838118
 * @since   1.0
 * @version	2.0
 * @date 07.10.2019
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
public class Aufgabe1 extends JPanel implements ActionListener {
	
	private JPanel checkPanel = new JPanel();
	private JRadioButton rdbtnJa = new JRadioButton("Ja");
	private JRadioButton rdbtnNein = new JRadioButton("Nein");
	private ButtonGroup btnGroup = new ButtonGroup();
	
    private Timer timer = null;
    private JButton btnStart = new JButton("start");
    private JLabel labelX = new JLabel("X");
    private Point point = new Point();
	private String status = null;
	private String answer = new String();
	private int diff = 0;
	private int sec;
	private int count = 0;
	
	private int[] startingPointUeberschwelig = {255, 200, 150, 115, 100, 80};
	private int[] startingPoinUnterschwaelig = {0, 10, 15, 30, 45, 60};
	
	/**
	 * 
	 * @param width	Breite des JPanels
	 * @param height Höhe des JPanels
	 */
    public Aufgabe1(int width, int height) {
        setLayout(null);
        setBackground(Color.BLACK);
        
        btnStart.setPreferredSize(new Dimension(width/4, btnStart.getFont().getSize()*2));
        btnStart.addActionListener(this);
        
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
        updateSize(width, height);
    }
    /**
     * Dient der initialisierung der Status variable.Wird einmalig, nach drücken
     * des Start Buttons ausgeführt. 
     */
    public void run() {
    	if(status == null) {
        	// create random object
            Random randomno = new Random();
            // get next next boolean value 
            boolean chooseState = randomno.nextBoolean();
            //
            if(chooseState) {
            	status = new String("ueberschwellig");
            } else if(!chooseState) {
            	status = new String("unterschwellig");
            }
        	getStateStartingPoint();
    	}
    }
    /**
     * Setzt die variable sec auf einen initialen Wert, abhängig vom status
     */
    public void getStateStartingPoint() {
    	if(status.equals("ueberschwellig")) {
			sec = startingPointUeberschwelig[new Random().nextInt(6)];
		} else if(status.equals("unterschwellig")) {
			sec =  startingPoinUnterschwaelig[new Random().nextInt(6)];
		}
		count++;
    }

    /**
     * Receives messages from button start and point's timer.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    	int delay = 300;
    	boolean isStatusChanged = false;
    	
        Object src = e.getSource();
        //---------------------------------------------------------------------
        if (src == btnStart) {
            run();
            showPoint(delay);
            btnStart.setVisible(false);
            checkPanel.setVisible(true);
        //---------------------------------------------------------------------
        } else if (src == timer&& isStatusChanged == false) {
            showX();
        //---------------------------------------------------------------------
        } else if (src == rdbtnJa) {
        	if(status.equals("ueberschwellig")) {
				diff = -20;
				
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
        
        if(isStatusChanged && count < 7) {
        	getStateStartingPoint();
        	isStatusChanged = false;
        }
    }
    
    /**
     * Wird von der Oberklasse aufgerufen. zeichnet einen Punkt auf die Oberflche. 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!labelX.isVisible()) {
        	int pointSize = 2;	//Wenn die grösse 1 ist, ist der Punkt nicht mehr sichtbar
        	
            g.setColor(new Color(sec, sec, sec));
            g.fillOval(point.x, point.y, pointSize, pointSize);
        }
    }

    /**
     * Setzt lableX auf nicht Sichbar und start den timmer welchesdie Funktion
     * {@link #actionPerformed(ActionEvent)} nach einer weile (duration).
     *
     * @param duration Dauer des Timers bzw. Verzögerung
     */
    private void showPoint(int duration) {
    	sec = sec + diff;
    	
    	checkPanel.setVisible(false);
        labelX.setVisible(false);
        
        timer = new Timer(duration, this);
        timer.start();
    }

    /**
     * Stopt den timer welches durch {@link #showPoint(int)} activiert wurde und setzt labelX auf Sichtbar.
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
     * Propotionen der Komponenten der Oberfläche berechnen und setzen.
     * @param width	Breite des JPanels
	 * @param height Höhe des JPanels
     */
    private void updateSize(int width, int height) {
    	//Propotion des labelX, also der sichtbaren x berechnen:
        int dimX = (int) (btnStart.getFont().getSize() * 2);
        labelX.setBounds((width - dimX) / 2, (height - dimX) / 2, dimX, dimX);
        
        btnStart.setBounds(0, 0, width, 23);
		checkPanel.setBounds(0, height-33, width, 33);
		//Position des Punktes berechnen
        point.x = width / 2;
        point.y = height / 2;
        
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

