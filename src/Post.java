import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;

public class Post extends JFrame {
	static String  filename=null;
	int s=0;
	static byte[]  personal_image;
	Item I=new Item();
	Question Q=new Question();
	ItemDataAccess IDA=new ItemDataAccess();
	QuestionDataAccess QDA=new QuestionDataAccess();
	private JPanel contentPane;
	private JTextField ID;
	private JTextField Name;
	private JTextField Description;
	private JTextField Date;
	private JTextField Question;
	private JTextField Answer;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public boolean isInteger( String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}
	public Post(Person P) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 46, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setBounds(10, 92, 81, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date");
		lblNewLabel_3.setBounds(10, 151, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setBounds(10, 192, 46, 14);
		contentPane.add(lblQuestion);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(10, 240, 46, 14);
		contentPane.add(lblAnswer);
		
		ID = new JTextField();
		ID.setBounds(92, 8, 152, 20);
		contentPane.add(ID);
		ID.setColumns(10);
		
		Name = new JTextField();
		Name.setBounds(91, 43, 223, 17);
		contentPane.add(Name);
		Name.setColumns(10);
		
		Description = new JTextField();
		Description.setBounds(92, 77, 223, 61);
		contentPane.add(Description);
		Description.setColumns(10);
		
		Date = new JTextField();
		Date.setBounds(92, 149, 223, 17);
		contentPane.add(Date);
		Date.setColumns(10);
		
		Question = new JTextField();
		Question.setBounds(92, 177, 233, 44);
		contentPane.add(Question);
		Question.setColumns(10);
		
		Answer = new JTextField();
		Answer.setBounds(92, 237, 233, 70);
		contentPane.add(Answer);
		Answer.setColumns(10);
		
		JButton btnPost = new JButton("Post");
		btnPost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean status=true;
				String id=ID.getText();
				String name=Name.getText();
				String description=Description.getText();
				String date=Date.getText();
				String question=Question.getText();
				String answer=Answer.getText();
				boolean statuss=isInteger(id);
				if(statuss==true)
				{
					int id1=Integer.parseInt(id);
					status=IDA.Validation(id1);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid ID");
				}
				if(status==true&&isInteger(id))
				{
					int id1=Integer.parseInt(id);
					I.SetID(id1);
					I.SetPosterID(P.getNID());
					I.SetDescription(description);
					I.SetDate(date);
					I.SetPic(personal_image);
					I.SetName(name);
					Q.SetQuestion(question);
					Q.SetAnswer(answer);
					IDA.add(I);
					QDA.add(Q,I.getID());
					UserIn In=new UserIn(P);
					In.setVisible(true);
				}
			}
		});
		btnPost.setBounds(520, 360, 89, 23);
		contentPane.add(btnPost);
		
		JLabel lblPicture = new JLabel("Picture");
		lblPicture.setBounds(10, 364, 46, 14);
		contentPane.add(lblPicture);
		
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
	    
	    btnAttach.setBounds(104, 360, 89, 23);
	    getContentPane().add(btnAttach);
	    
	}

}
