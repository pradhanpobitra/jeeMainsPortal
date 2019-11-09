package noName;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class SecondPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	String gender = null;
	String category = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondPage frame = new SecondPage();
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
	public SecondPage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 740);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrationForm = new JLabel("JEE MAINS REGISTRATION FORM");
		lblRegistrationForm.setFont(new Font("Sitka Subheading", Font.BOLD, 30));
		lblRegistrationForm.setBounds(143, 43, 494, 96);
		contentPane.add(lblRegistrationForm);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblName.setBounds(139, 162, 84, 49);
		contentPane.add(lblName);
		
		JLabel label = new JLabel("Date Of Birth :");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(81, 244, 142, 35);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Phone Number :");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(65, 314, 170, 35);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Gender :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_2.setBounds(128, 390, 95, 35);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Category :");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_3.setBounds(107, 456, 116, 35);
		contentPane.add(label_3);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e) 
			{
			char c= e.getKeyChar();
			if((Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c) ) )
			{												      
				      textField.setEditable(true);				
			}
			else
			textField.setEditable(false);
			
			}
			 
			@Override
			public void keyReleased(KeyEvent e) {
				int position = textField.getCaretPosition();
				textField.setText(textField.getText().toUpperCase());
				textField.setCaretPosition(position);
			}
		});
		textField.setBounds(376, 173, 261, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e) {
				
				char d=e.getKeyChar();
				if(Character.isDigit(d) || Character.isISOControl(d))
					textField_1.setEditable(true);
				else
					textField_1.setEditable(false);
				
			}
			
			
		});
		textField_1.setColumns(10);
		textField_1.setBounds(408, 317, 229, 35);
		contentPane.add(textField_1);
		ButtonGroup bg= new ButtonGroup();
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			gender="Male";
			}
		});
		rdbtnMale.setBackground(new Color(32, 178, 170));
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rdbtnMale.setBounds(310, 398, 76, 27);
		contentPane.add(rdbtnMale);
		bg.add(rdbtnMale);
		
		JRadioButton radioButton = new JRadioButton("Female");
		radioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gender="Female";
			}
		});
		radioButton.setBackground(new Color(32, 178, 170));
		radioButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioButton.setBounds(436, 398, 84, 27);
		contentPane.add(radioButton);
		bg.add(radioButton);
		JRadioButton radioButton_1 = new JRadioButton("Others\r\n");
		radioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				gender="Others";
			}
		});
		radioButton_1.setBackground(new Color(32, 178, 170));
		radioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioButton_1.setBounds(568, 398, 84, 27);
		contentPane.add(radioButton_1);
		bg.add(radioButton_1);
		JComboBox<String> comboBox = new JComboBox();
		comboBox.addItem(" ");
		comboBox.addItem("General");
		comboBox.addItem("OBC");
		comboBox.addItem("SC");
		comboBox.addItem("ST");
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBounds(495, 461, 142, 31);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 category= comboBox.getSelectedItem().toString();
				
			}
		});
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(415, 244, 223, 35);
		contentPane.add(dateChooser);
		
		
		
		JButton btnSubmitAndGo = new JButton("SUBMIT AND GO ->>");
		btnSubmitAndGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				
				String  x=((JTextFieldDateEditor)dateChooser.getDateEditor().getUiComponent()).getText();
				if(!((x.charAt(7)=='2' && x.charAt(8)=='0' && x.charAt(9)=='0' && x.charAt(10)<='1')|| (x.charAt(7)=='1' && x.charAt(8)=='9' && x.charAt(9)=='9' && x.charAt(10)=='9' )))
					{JOptionPane.showMessageDialog(null, "NOT ELIGIBLE");
				    System.exit(0);
					}
				Pattern p=Pattern.compile("^[6-9][0-9]{9}$");
				java.util.regex.Matcher m=p.matcher(textField_1.getText());
				if(!m.matches())
				{
					JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
					setVisible(false);
					dispose();
					return;
				}
				
				
				
				
				try
				{
				String query="insert into student6 values(null,?,?,?,?,?)";
				String url = "jdbc:mysql://localhost:3306/jeemains1";
				String uname="root";
				String pass="Chayanikaislove";
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,uname,pass);
				PreparedStatement st =con.prepareStatement(query);
				int count=0;
				
					st.setString(1,textField.getText());
					st.setString(2,((JTextFieldDateEditor)dateChooser.getDateEditor().getUiComponent()).getText());
					st.setString(3, gender);
					st.setString(4, category);
					st.setString(5, textField_1.getText());
					count = st.executeUpdate();
					st.close();
					
					String name=textField.getText();
					String phno = textField_1.getText();
					query="select rollNo from student6 where name='"+name+"'AND PhoneNo='"+phno+"';";
					Statement st2= con.createStatement();
					ResultSet rs=st2.executeQuery(query);
					rs.next();
					int a=rs.getInt("rollNo");
					String s = Integer.toString(a);

					JOptionPane.showMessageDialog(null, "Registration Successful\nYour Roll NO is : "+s);
					
					
					con.close();
					setVisible(false);
					dispose();
					
				}
				catch(Exception ex)
				{
					System.out.print(ex);
				}
			
		}});
		
		btnSubmitAndGo.setFont(new Font("MV Boli", Font.PLAIN, 17));
		btnSubmitAndGo.setBounds(471, 571, 208, 49);
		contentPane.add(btnSubmitAndGo);
		
		
		
	}
}
