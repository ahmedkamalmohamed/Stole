import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class Home {

	private JFrame frame;
	private JTextField ID;
	private JPasswordField Password;
	Person P=new Person();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}
	
	public boolean isInteger( String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PersonDataaccess Obj=new PersonDataaccess();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ID = new JTextField();
		ID.setBounds(170, 38, 218, 20);
		frame.getContentPane().add(ID);
		ID.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = ID.getText();
				String Pass=Password.getText();
				boolean Status=true;
				boolean statuss=isInteger(id);
				if(statuss==true)
				{
					int id1=Integer.parseInt(ID.getText());
					Status=Obj.Validation(id1, Pass, P);
				}
				if(Status==true&&isInteger(id))
				{	
					JOptionPane.showMessageDialog(null,"Welcome Mr."+P.getname());
					UserIn In=new UserIn(P);
					frame.dispose();
					In.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Bad boy");
				}
			}
		});
		btnLogin.setBounds(53, 197, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp In=new SignUp();
				frame.dispose();
				In.setVisible(true);
			}
		});
		btnSignUp.setBounds(288, 197, 89, 23);
		frame.getContentPane().add(btnSignUp);
		
		JLabel lblUserName = new JLabel("ID");
		lblUserName.setBounds(71, 40, 89, 17);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(56, 99, 58, 17);
		frame.getContentPane().add(lblPassword);
		
		Password = new JPasswordField();
		Password.setBounds(170, 97, 218, 20);
		frame.getContentPane().add(Password);
		
	}
	
}
