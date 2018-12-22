import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserIn extends JFrame  {
	private JFrame frame;
	private JPanel contentPane;
	ItemDataAccess IDA=new ItemDataAccess();
	Item item=new Item();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public void getimage(Person P)
	{			 
		JLabel label = new JLabel();
		label.setBounds(597, 11, 188, 94);	
	 	contentPane.add(label);
	 	
	 	JLabel lblNewLabel = new JLabel("Welcome Mr."+P.getname());
	 	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
	 	lblNewLabel.setBounds(607, 112, 188, 32);
	 	contentPane.add(lblNewLabel);
        ImageIcon image = new ImageIcon(P.getPic());
        Image im = image.getImage();
        Image myImg = im.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon newImage = new ImageIcon(myImg);
         label.setIcon(newImage);
         System.out.print(P.getPic());
	}
	public UserIn(Person P) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getimage(P);
	 	IDA.getdata(item);
		JList list = new JList(IDA.list);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index=IDA.list.indexOf(list.getSelectedValue());
				JOptionPane.showMessageDialog(null,"Clicked On "+IDA.list.elementAt(index));
				Item I=new Item();
				IDA.getdatax(IDA.list.elementAt(index),I);
				System.out.print(I.getID());
				Items In=new Items(I);
				In.setVisible(true);
			}
		});
	 	list.setBounds(10, 11, 288, 393);
	 	contentPane.add(list);
	 	
	 	JButton btnPost = new JButton("Post");
	 	btnPost.addActionListener(new ActionListener() {
	 		public void actionPerformed(ActionEvent e) {
	 			Post Po=new Post(P);
	 			Po.setVisible(true);
	 		}
	 	});
	 	btnPost.setBounds(678, 369, 89, 23);
	 	contentPane.add(btnPost);
	 	
	}
}
