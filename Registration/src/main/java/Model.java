import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {
	
	private String uName;
	private String uEmail;
	private String password;
	private Connection connect=null;
	private PreparedStatement pstmt=null;
	private int row;
	
	
	
	public String getuName()
	{
		return uName;
	}
	public void setuname(String name)
	{
		this.uName=name;
	}
	
	
	public String getuEmail()
	{
		return uEmail;
	}
	public void setuEmail(String email)
	{
		this.uEmail=email;
	}
	
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String pass)
	{
		this.password=pass;
	}
	
	
	public int register()
	{
		try {
		 connect=JdbcUtil.getDBConnection();
		 //Insert the data to database
		String sql="insert into signup (User,Email,Password)"+" values (?,?,?)";
		pstmt=connect.prepareStatement(sql);
		pstmt.setString(1, uName);
		pstmt.setString(2, uEmail);
		pstmt.setString(3, password);
		
		 row = pstmt.executeUpdate();
		 
		
		 
		
//		while(rs.next())
//		{
//			String name=rs.getString(1);
//			String email=rs.getString(2);
//			String password=rs.getString(3);
//			
//			System.out.println(name+" "+email+" "+password);
//		}
		
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				JdbcUtil.closeResource(connect, pstmt);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return row;
	}
	
	
}
