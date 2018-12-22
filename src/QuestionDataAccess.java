import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class QuestionDataAccess {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	public QuestionDataAccess()
	{
		try {
    		Class.forName("com.mysql.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false",/*UserName*/,"Mahmoued23"/*PassWord*/);
    		st=con.createStatement();
    	}
    	catch(Exception ex)
    	{
    		System.out.print("S"+ex);
    	}
	}
	public void getdatax(Object object,Question Q)
	{	    	
		ItemDataAccess Access=new ItemDataAccess();
		try
		{
			String query="SELECT * FROM `questions` WHERE ID ="+"'"+object+"'";
			rs= st.executeQuery(query);
			while(rs.next())
			{
				Q.SetID(rs.getInt(1));
				Q.SetQuestion(rs.getNString(2));
				Q.SetAnswer(rs.getNString(3));
			}
		}
		catch(Exception ex)
		{
			
		}
	}
	public boolean Validation(String Ans)
	{	    	
		ItemDataAccess Access=new ItemDataAccess();
		try {
			String query="SELECT * FROM `questions` WHERE Answer LIKE"+"'"+Ans+"'";
			rs= st.executeQuery(query);
			
			if(!rs.isBeforeFirst()) {
    			return false;
    		}
    		else
    		{
    			return true;
    		}
    		
    	}
    	catch(Exception ex)
    	{
    		return false;
    	}
    }
	public void add(Question Q,int Item_ID)
    {	
    	QuestionDataAccess Access=new QuestionDataAccess();
    	try
    	{	
    		String query = " insert into questions (ID, Question, Answer)"
    		        + " values (?, ?, ?)";
    		PreparedStatement preparedStmt = con.prepareStatement(query);
    	      preparedStmt.setInt (1, Item_ID);
    	      preparedStmt.setString(2, Q.getQuestion());
    	      preparedStmt.setString(3, Q.getAnswer());
    	      preparedStmt.execute();
    	}catch(Exception Ex)
    	{
    		System.err.println("Got an exception!");
    	      System.err.println(Ex.getMessage());
    	}
    }
}

