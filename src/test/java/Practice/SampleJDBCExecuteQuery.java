package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws Throwable 
	{
		Driver driver = new Driver();//take driver from MYSQL
		
		//step 1-register the database
		DriverManager.registerDriver(driver);
		
		//step 2-get the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/organizationdb", "root", "root");
		
		//step 3-create statement
		Statement state = con.createStatement();
		
		//step 4-execute a query
		ResultSet result = state.executeQuery("select * from orginfo");
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getInt(2)+" "+result.getString(3));
			
		}
		//step 5-close database
		con.close();
		
	}

}
