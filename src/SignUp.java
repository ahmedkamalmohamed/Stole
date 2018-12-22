import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.awt.Panel;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Canvas;

public class SignUp extends JFrame{
	//private JFrame frame;
	static String  filename=null;
	int s=0;
	static byte[]  personal_image;
	Person P=new Person();
	PersonDataaccess Obj=new PersonDataaccess();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

    public SignUp(){
    super("retrieve image from database in java");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(700,400);
    getContentPane().setLayout(null);
    
    JLabel lblName = new JLabel("Name");
    lblName.setBounds(10, 17, 67, 32);
    getContentPane().add(lblName);
    
    JLabel lblEmail = new JLabel("Email");
    lblEmail.setBounds(10, 54, 67, 38);
    getContentPane().add(lblEmail);
    
    JLabel lblID = new JLabel("NID");
    lblID.setBounds(10, 103, 67, 32);
    getContentPane().add(lblID);
    
    JLabel lblPassword = new JLabel("Password");
    lblPassword.setBounds(10, 146, 56, 32);
    getContentPane().add(lblPassword);
    
    JLabel lblPhoneNum = new JLabel("Phone Number");
    lblPhoneNum.setBounds(10, 179, 95, 32);
    getContentPane().add(lblPhoneNum);
    
    JLabel lblRate = new JLabel("Rate");
    lblRate.setBounds(10, 222, 67, 32);
    getContentPane().add(lblRate);
    
    JLabel lblPhoto = new JLabel("Photo");
    lblPhoto.setBounds(10, 265, 67, 32);
    getContentPane().add(lblPhoto);
    
    textField = new JTextField();
    textField.setBounds(101, 17, 309, 32);
    getContentPane().add(textField);
    textField.setColumns(10);
    
    textField_1 = new JTextField();
    textField_1.setBounds(101, 63, 309, 29);
    getContentPane().add(textField_1);
    textField_1.setColumns(10);
    
    textField_2 = new JTextField();
    textField_2.setBounds(101, 103, 309, 32);
    getContentPane().add(textField_2);
    textField_2.setColumns(10);
    
    textField_3 = new JTextField();
    textField_3.setBounds(101, 185, 309, 32);
    getContentPane().add(textField_3);
    textField_3.setColumns(10);
    
    textField_4 = new JTextField();
    textField_4.setBounds(102, 228, 86, 20);
    getContentPane().add(textField_4);
    textField_4.setColumns(10);
    
    JButton btnAttach = new JButton("Attach");
    btnAttach.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		JFileChooser chooser=new JFileChooser();
    		chooser.showOpenDialog(null);
    		File f=chooser.getSelectedFile();
    		String filename=f.getAbsolutePath();
    		try {
    			File image=new File(filename);
    			FileInputStream fis=new FileInputStream(image);
    			ByteArrayOutputStream bos=new ByteArrayOutputStream();
    			byte[] buf= new byte[1024];
    			for(int readNum;(readNum=fis.read(buf))!=-1;)
    			{
    				bos.write(buf,0,readNum);
    			}
    			personal_image=bos.toByteArray();
    		}
    		catch(Exception ex)
    		{
    			JOptionPane.showMessageDialog(null,ex);
    		}
    	}
    });
    
    btnAttach.setBounds(99, 270, 89, 23);
    getContentPane().add(btnAttach);
    
    JButton btnDone = new JButton("Done");
    btnDone.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		boolean Status=true;
			String NID=textField_2.getText();
			String PhoneNumber =textField_3.getText();
			String Rate=textField_4.getText();
			boolean statuss=isInteger(NID);
			boolean statuss1=isInteger(PhoneNumber);
			boolean statuss2=isInteger(Rate);
			if(statuss==true)
			{
				int id1=Integer.parseInt(NID);
				Status=Obj.Validation(id1);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Invalid ID");
			}
			if(statuss1==true)
			{
				int id1=Integer.parseInt(PhoneNumber);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Invalid PhoneNumber");
			}
			if(statuss2==true)
			{
				int id1=Integer.parseInt(Rate);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Invalid Rate");
			}
			if(Status==true&&isInteger(NID)&&isInteger(Rate)&&isInteger(PhoneNumber))
			{
				P.Setname(textField.getText());
				P.SetEmail(textField_1.getText());
				int id1=Integer.parseInt(NID);
				P.SetNID(id1);
				P.SetPass(textField_5.getText());
				int id2=Integer.parseInt(PhoneNumber);
				P.SetPhoneN(id2);
				int id3=Integer.parseInt(Rate);
				P.SetRate(id3);
				JOptionPane.showMessageDialog(null,"Welcome");
				P.SetPic(personal_image);
				Obj.add(P);
				UserIn In=new UserIn(P);
				In.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null,"Invalid");
			}
    	}
    });
    btnDone.setBounds(574, 327, 89, 23);
    getContentPane().add(btnDone);
    
    JLabel ImageLabel = new JLabel("");
    ImageLabel.setBounds(232, 243, 192, 92);
    getContentPane().add(ImageLabel);
    
    
    
    textField_5 = new JTextField();
    textField_5.setBounds(101, 146, 309, 32);
    getContentPane().add(textField_5);
    textField_5.setColumns(10);
    setVisible(true);
   
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
   }
