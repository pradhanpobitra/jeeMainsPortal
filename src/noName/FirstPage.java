package noName;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import noName.*;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class FirstPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPage window = new FirstPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(255, 255, 224));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		
		JLabel lblJeeMainsPortal = new JLabel("JEE MAINS PORTAL");
		lblJeeMainsPortal.setForeground(new Color(255, 255, 224));
		lblJeeMainsPortal.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblJeeMainsPortal.setBounds(147, 10, 272, 88);
		frame.getContentPane().add(lblJeeMainsPortal);
		
		JButton btnRegister = new JButton("Register ");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SecondPage qe=new SecondPage();
				  qe.show();
			}
		});
		btnRegister.setForeground(new Color(250, 235, 215));
		btnRegister.setBackground(new Color(0, 0, 128));
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRegister.setBounds(230, 120, 108, 53);
		frame.getContentPane().add(btnRegister);
		
		JButton button = new JButton("Enter Marks");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Third obj=new Third();
				obj.show();
			}
		});
		button.setForeground(new Color(255, 255, 224));
		button.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button.setBackground(new Color(0, 0, 128));
		button.setBounds(220, 177, 131, 65);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Check My Result");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChMy obj1=new ChMy();
				obj1.show();
			}
		});
		button_1.setForeground(new Color(255, 255, 224));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_1.setBackground(new Color(0, 0, 128));
		button_1.setBounds(102, 252, 168, 65);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Check Batch Result");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckAll obj5=new CheckAll();
				obj5.show();
			}
		});
		button_2.setForeground(new Color(255, 255, 224));
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		button_2.setBackground(new Color(0, 0, 128));
		button_2.setBounds(291, 252, 180, 65);
		frame.getContentPane().add(button_2);
		frame.setBounds(100, 100, 595, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
