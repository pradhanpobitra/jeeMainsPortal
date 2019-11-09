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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Third extends JFrame {

	private static final Exception Exception = null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	int hey;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args)	throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Third frame = new Third();
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
	@SuppressWarnings("deprecation")
	public Third() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 606, 538);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterYourMarks = new JLabel("Enter your marks in Physics :");
		lblEnterYourMarks.setFont(new Font("Sitka Subheading", Font.PLAIN, 20));
		lblEnterYourMarks.setBounds(65, 141, 286, 62);
		contentPane.add(lblEnterYourMarks);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c=e.getKeyChar();
				if (Character.isDigit(c) || Character.isISOControl(c) || c=='-')
					textField.setEditable(true);
				else
					textField.setEditable(false);
			}
		});
	
		textField.setBounds(407, 157, 138, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("Enter your marks in Chemistry :");
		label.setFont(new Font("Sitka Subheading", Font.PLAIN, 20));
		label.setBounds(41, 213, 286, 62);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Enter your marks in Mathematics :");
		label_1.setFont(new Font("Sitka Subheading", Font.PLAIN, 20));
		label_1.setBounds(21, 280, 317, 62);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char d=e.getKeyChar();
				if(Character.isDigit(d) || Character.isISOControl(d) || d=='-')
					textField_1.setEditable(true);
				else
					textField_1.setEditable(false);
				
			}
		});
	
		textField_1.setColumns(10);
		textField_1.setBounds(407, 227, 138, 29);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char d=e.getKeyChar();
				if(Character.isDigit(d) || Character.isISOControl(d) || d=='-')
					textField_2.setEditable(true);
				else
					textField_2.setEditable(false);
				
			}
		});
		
		textField_2.setColumns(10);
		textField_2.setBounds(407, 296, 138, 29);
		contentPane.add(textField_2);
		textField_3 = new JTextField();
		textField_3.setBounds(409, 112, 136, 25);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setForeground(new Color(0, 0, 128));
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					 hey=Integer.parseInt(textField_3.getText());
					int p=Integer.parseInt(textField.getText());
					int c=Integer.parseInt(textField_1.getText());
					int m=Integer.parseInt(textField_2.getText());
					int total=p+c+m;
					if(p>100 || p<-100 || c>100 || c<-100 || m>100 || m<-100)
					{
						JOptionPane.showMessageDialog(null, "INVALID ENTRY/ENTRIES");
						setVisible(false);
						dispose();
						return;
					}
					String query2="select count(*) from student6";
				String query="insert into marks1 values(?,?,?,?,?);";
				String url = "jdbc:mysql://localhost:3306/jeemains1";
				String uname="root";
				String pass="Chayanikaislove";
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,uname,pass);
				PreparedStatement st =con.prepareStatement(query);
				PreparedStatement st2 =con.prepareStatement(query2);
				ResultSet rs3=st2.executeQuery(query2);
				rs3.next();
				int max=rs3.getInt(1);
				if(hey>max)
				{
					JOptionPane.showMessageDialog(null, "PLEASE REGISTER YOURSELF FIRST");
					setVisible(false);
					dispose();
					return;
				}
				int count=0;
					st.setInt(1,hey);
					st.setInt(2,p);
					st.setInt(3,c);
					st.setInt(4, m);
					st.setInt(5, total);
					
					count = st.executeUpdate();
					st.close();
					
					con.close();
					JOptionPane.showMessageDialog(null, "Marks Entry Successful");
					setVisible(false);
					dispose();
					
				
					
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			
				
				
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.setBounds(247, 382, 104, 44);
		contentPane.add(btnSubmit);
		
		JLabel lblMarksEntryForm = new JLabel("MARKS ENTRY FORM");
		lblMarksEntryForm.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblMarksEntryForm.setBounds(144, 58, 292, 44);
		contentPane.add(lblMarksEntryForm);
		
		JLabel lblRollNo = new JLabel("ROLL NO");
		lblRollNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRollNo.setBounds(241, 118, 86, 13);
		contentPane.add(lblRollNo);
		
		
		
	}
}
