package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class sampleJDBCExecuteUpdate {

	public static void main(String[] args) throws Throwable
	{
Driver driver = new Driver();//take driver from MYSQL
		
		//step 1-register the database
		DriverManager.registerDriver(driver);
		
		//step 2-get the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/organizationdb", "root", "root");
		
		//step 3-create statement
		Statement state = con.createStatement();
		
		//step 4-update a query
		String query = "insert into orginfo values('jega','5','bangalore')";
		int result = state.executeUpdate(query);
		if(result==1)
		{
			System.out.println("data is added");
		}
		//step 5-close database
		con.close();
		

	}

}
