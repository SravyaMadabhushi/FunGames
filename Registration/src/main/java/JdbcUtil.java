import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		System.out.println("Driver is registered");
		
	}
	
	public static Connection getDBConnection() throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/userdb";
		String root="root";
		String password="M!9j8e1m9";
		
		return DriverManager.getConnection(url,root,password);
	}
	public static void closeResource(Connection connect,Statement stmt) throws SQLException
	{
		if(connect != null)
		{
			connect.close();
		}
		if(stmt != null)
		{
			stmt.close();
		}
	}
	
}
