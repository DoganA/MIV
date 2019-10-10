package Aufgaben;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Oberfläche extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnStart;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Create Start Button, to start whole event
		btnStart = new JButton("Start");
		btnStart.setBounds(0, 0, 776, 21);
		btnStart.addActionListener(this);
		btnStart.setVisible(true);
		btnStart.setActionCommand("StartButtonPresses");
		contentPane.add(btnStart);
	}
	/**
	 * Perform all Listener
	 */
	public void actionPerformed(ActionEvent e) {
		//In case of Start the event
		if(e.getActionCommand() == "StartButtonPresses") {
			btnStart.setVisible(false);
		}
	}
}
