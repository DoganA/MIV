import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Aufgabe1 extends JFrame {

	private JPanel contentPane;
	private JLabel lblPointStr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aufgabe1 frame = new Aufgabe1();
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
	public Aufgabe1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		
		lblPointStr = new JLabel("X");
		lblPointStr.setForeground(Color.WHITE);
		lblPointStr.setHorizontalAlignment(JLabel.CENTER);
		lblPointStr.setVerticalAlignment(JLabel.CENTER);
		contentPane.add(lblPointStr);
	}

}
