import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {

	private String  user;
	private String password;
	private Connection connect;
	private PreparedStatement pstmt;
	private int row;
	
	public String getUser()
	{
		return user;
	}
	public void setUser(String user)
	{
		this.user=user;
	}
	
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String pass)
	{
		this.password = pass;
	}
	
	public int registrationChecking()
	{
		int row=0;
		try
		{
			connect=JdbcUtil.getDBConnection();
			pstmt=connect.prepareStatement("select * from signup where user=? and  password=?");
			pstmt.setString(1, user);
			pstmt.setString(2, password);
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				System.out.println("Login Successful!!");
				row=1;
				return row;
			}
			else {
				System.out.println("Invalid username or password.");
				return row;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return row;
		
	}
}
