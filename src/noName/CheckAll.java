package noName;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CheckAll extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckAll frame = new CheckAll();
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
	public CheckAll() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1048, 724);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 125, 565, 540);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(606, 125, 407, 540);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		JButton btnViewFullResult = new JButton("VIEW FULL RESULT");
		btnViewFullResult.setForeground(Color.BLACK);
		btnViewFullResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String query="select * from student6";
					String query2="select marksPhy,marksChem,marksmath,totalMarks from marks1 order by rollNo";
					String url = "jdbc:mysql://localhost:3306/jeemains1";
					String uname="root";
					String pass="Chayanikaislove";
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,uname,pass);
					PreparedStatement st =con.prepareStatement(query);
					PreparedStatement st2 =con.prepareStatement(query2);
					ResultSet rs=st.executeQuery();
					ResultSet rs2=st2.executeQuery();
//					rs.next();
//					rs2.next();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					table_1.setModel(DbUtils.resultSetToTableModel(rs2));
					
				}catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
		btnViewFullResult.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnViewFullResult.setBounds(42, 34, 281, 67);
		contentPane.add(btnViewFullResult);
		
		
	}
}
