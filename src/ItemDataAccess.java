import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class ItemDataAccess {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	Vector list=new Vector();
	Item item;
	public ItemDataAccess() {
		try {
    		Class.forName("com.mysql.jdbc.Driver");
    		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database?autoReconnect=true&useSSL=false",""/*UserName*/,""/*PassWord*/);
    		st=con.createStatement();
    	}
    	catch(Exception ex)
    	{
    		System.out.print("S"+ex);
    	}
	}
	public void getdata(Item item)
	{	    	
		ItemDataAccess Access=new ItemDataAccess();
		try
		{
			String query="SELECT * FROM `items` WHERE 1";
			rs= st.executeQuery(query);
			while(rs.next())
			{
				item.SetID(rs.getInt(1));
				item.SetPosterID(rs.getInt(2));
				item.SetName(rs.getNString(3));
				list.add(rs.getNString(3));
				item.SetDescription(rs.getNString(4));
				item.SetDate(rs.getString(5));
				item.SetPic(rs.getBytes(6));
			}
		}
		catch(Exception ex)
		{
			
		}
	}
	public boolean Validation(int ID)
    {
		ItemDataAccess Access=new ItemDataAccess();
    	try {
    		String query="SELECT * FROM `items` WHERE `ID` = "+ID;
    		rs=st.executeQuery(query);
    		if(!rs.isBeforeFirst()) {
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    		
    	}
    	catch(Exception ex)
    	{
    		return true;
    	}
    }
	public void getdatax(Object object,Item I)
	{	    	
		ItemDataAccess Access=new ItemDataAccess();
		try
		{
			String query="SELECT * FROM `items` WHERE name ="+"'"+object+"'";
			rs= st.executeQuery(query);
			while(rs.next())
			{
				I.SetID(rs.getInt(1));
				I.SetPosterID(rs.getInt(2));
				I.SetName(rs.getNString(3));
				I.SetDescription(rs.getNString(4));
				I.SetDate(rs.getString(5));
				I.SetPic(rs.getBytes(6));
			}
		}
		catch(Exception ex)
		{
			
		}
	}
	public void add(Item I)
    {	
    	ItemDataAccess Access=new ItemDataAccess();
    	try
    	{	
    		String query = " insert into items (ID, Poster, name, Description, Date, pic)"
    		        + " values (?, ?, ?, ?, ?,?)";
    		PreparedStatement preparedStmt = con.prepareStatement(query);
    	      preparedStmt.setInt (1, I.getID());
    	      preparedStmt.setLong(2, I.getPosterID());
    	      preparedStmt.setString (3, I.getName());
    	      preparedStmt.setString(4,  I.getDescription());
    	      preparedStmt.setString(5, I.getDate());
    	      preparedStmt.setBytes(6, I.getPic());
    	      preparedStmt.execute();
    	}catch(Exception Ex)
    	{
    		System.err.println("Got an exception!");
    	      System.err.println(Ex.getMessage());
    	}
    }
}