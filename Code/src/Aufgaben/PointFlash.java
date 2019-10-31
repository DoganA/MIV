package Aufgaben;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.Timer;
/**
 * TODO RadioButton disselect, StartButton after press deactivate,
 * @author Dogan
 *
 */
@SuppressWarnings("serial")
public class PointFlash extends JPanel implements ActionListener {
	
	private JPanel checkPanel = new JPanel();
	private JRadioButton rdbtnJa = new JRadioButton("Ja");
	private JRadioButton rdbtnNein = new JRadioButton("Nein");
	private ButtonGroup btnGroup = new ButtonGroup();
	
    private Timer timer = null;
    private JButton btnStart = new JButton("start");
    private JLabel labelX = new JLabel("X");
    private Point point = new Point();
    private int pointSize = 2;	//Wenn die größe 1 ist, ist der Punkt nicht mehr sichtbar
	private String status = new String();
	private String answer = new String();
	private int diff = 0;
	private int sec = 0;
	private int count = 0;

    public PointFlash(int width, int height) {
        setLayout(null);
        setBackground(Color.BLACK);
        btnStart.setPreferredSize(new Dimension(width/4, btnStart.getFont().getSize()*2));
//        labelX.setBorder(BorderFactory.createLineBorder(color));
        labelX.setHorizontalAlignment(JLabel.CENTER);
        labelX.setForeground(Color.WHITE);
        
			btnGroup = new ButtonGroup();
			
//			rdbtnJa.setActionCommand("RadioButton_Ja");
			rdbtnJa.addActionListener(this);
			checkPanel.add(rdbtnJa);
			btnGroup.add(rdbtnJa);
			
//			rdbtnNein.setActionCommand("RadioButton_Nein");
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
     * Receives messages from button start and point's timer.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    	System.out.println("----------");
    	System.out.println("actionPerformed()");
        Object src = e.getSource();
        System.out.println("src :" + src.toString() );
        if (src == btnStart) {
            showPoint(2000);
            btnStart.setVisible(false);
            checkPanel.setVisible(true);
            count++;
        } else if (src == timer) {
        	System.out.println("actionPerform timer");
            showX();
        } else if (src == rdbtnJa && count <=6) {
        	System.out.println("actionPerform rdbtnja");
        	if(status.equals("ueberschwellig")) {
				diff = -20;
			} else {
				sec = 255;
				diff = 0;
				status = "ueberschwellig";
			}
			answer = "JA";
			count++;
        	showPoint(2000);
        } else if (src == rdbtnNein && count <6) {
        	System.out.println("actionPerform rdbtnNein");
        	if(status.equals("ueberschwellig")) {
				sec = 0;
				diff = 0;
				status = "unterschwellig";
			} else {
				diff = 20;
			}
			answer = "NEIN";
			count++;
        	showPoint(2000);
        } else if (count > 6) {
        	timer.stop();
		}
        System.out.println("Light Point status: " + status + " sec: " + sec + " answer: " + answer + " diff: " + diff + " count: " + count);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!labelX.isVisible()) {
//            g.setColor(color);
        	System.out.println(sec);
            g.setColor(new Color(sec, sec, sec));
            g.fillOval(point.x, point.y, pointSize, pointSize);
        }
    }

    /**
     * Sets lableX invisible and starts a timer which calls
     * {@link #actionPerformed(ActionEvent)} after duration.
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
     * Stops timer activated by {@link #showPoint(int)} and sets labelX visible.
     */
    private void showX() {
    	btnGroup.clearSelection();
        if (timer != null) {
            timer.stop();
            System.out.println("timer stoped");
        }
        timer = null;
        
        labelX.setVisible(true);
        checkPanel.setVisible(true);
    }

    private void updateSize(int width, int height) {
//        setPreferredSize(new Dimension(width, height));
        int dimX = (int) (btnStart.getFont().getSize() * 2);
        labelX.setBounds((width - dimX) / 2, (height - dimX) / 2, dimX, dimX);
        int startWidth = width / 5;
//        start.setBounds((width - startWidth) / 2, (height - dimX), startWidth, dimX);
        btnStart.setBounds(0, 0, width, 23);
        point.x = width / 2;
        point.y = height / 2;
        setPreferredSize(new Dimension(width, height));
        
        
//		checkPanel.setBounds(0, 229, 684, 33);
		checkPanel.setBounds(0, height-33, width, 33);

    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("draw point at center");
        frame.add(new PointFlash(700, 300));
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

