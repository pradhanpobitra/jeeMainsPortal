package noName;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChMy extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChMy frame = new ChMy();
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
	public ChMy() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 786, 613);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCheckYourResult = new JLabel("CHECK YOUR RESULT");
		lblCheckYourResult.setForeground(Color.BLACK);
		lblCheckYourResult.setFont(new Font("Sitka Subheading", Font.BOLD, 27));
		lblCheckYourResult.setBounds(231, 66, 325, 49);
		contentPane.add(lblCheckYourResult);
		
		JLabel lblEnterYourRoll = new JLabel("Enter Your Roll Number : ");
		lblEnterYourRoll.setForeground(Color.BLACK);
		lblEnterYourRoll.setFont(new Font("Sitka Text", Font.PLAIN, 20));
		lblEnterYourRoll.setBounds(147, 155, 244, 49);
		contentPane.add(lblEnterYourRoll);
		
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e) {
				
				char d=e.getKeyChar();
				if(Character.isDigit(d) || Character.isISOControl(d))
					textField.setEditable(true);
				else
					textField.setEditable(false);
				
			}
			
			
		});
		textField.setBounds(500, 162, 68, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		
		JLabel lblName = new JLabel("Name :");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Sitka Subheading", Font.PLAIN, 20));
		lblName.setBounds(274, 261, 73, 40);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(420, 261, 166, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblYourAllIndia = new JLabel("YOUR ALL INDIA RANK IS ::");
		lblYourAllIndia.setForeground(new Color(255, 0, 0));
		lblYourAllIndia.setFont(new Font("Sitka Subheading", Font.PLAIN, 22));
		lblYourAllIndia.setBounds(87, 380, 297, 63);
		contentPane.add(lblYourAllIndia);
		
		textField_2 = new JTextField();
		textField_2.setBounds(436, 380, 55, 45);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setBackground(Color.WHITE);
		lblCategory.setForeground(Color.BLACK);
		lblCategory.setFont(new Font("Sitka Subheading", Font.PLAIN, 20));
		lblCategory.setBounds(251, 321, 108, 33);
		contentPane.add(lblCategory);
		
		textField_4 = new JTextField();
		textField_4.setBounds(427, 324, 88, 25);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		textField_3 = new JTextField();
		textField_3.setBounds(436, 469, 55, 49);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		JButton btnCheck = new JButton("CHECK");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String a=textField.getText();
					int roll=Integer.parseInt(a);
				String query="select * from student6 where rollNo="+a;
				String url = "jdbc:mysql://localhost:3306/jeemains1";
				String uname="root";
				String pass="Chayanikaislove";
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,uname,pass);
				PreparedStatement st =con.prepareStatement(query);
					ResultSet rs=st.executeQuery(query);
					rs.next();
					
					
					textField_1.setText(rs.getString(2));
					textField_4.setText(rs.getString(5));
					
					
					String abc="select * from marks1 order by totalMarks desc";
					PreparedStatement st2 =con.prepareStatement(abc);
					ResultSet rs2=st2.executeQuery(abc);
					rs2.next();
					int rowno=1;
					while(roll !=rs2.getInt(1))
					{
						rowno++;
						rs2.next();
					}
					String sdf=Integer.toString(rowno);
					textField_2.setText(sdf);
					con.close();
					textField_3.setText(Integer.toString(rowno/2 + 1));
					//setVisible(false);
					//dispose();
					
				}
				catch(Exception ex)
				{
					System.out.print(ex);
				}
				
				
				
			}
		});
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCheck.setBounds(614, 155, 85, 49);
		contentPane.add(btnCheck);
		
		JLabel lblNewLabel = new JLabel("YOUR CATEGORY RANK IS:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(87, 473, 272, 33);
		contentPane.add(lblNewLabel);
		

	}
}
