package Practice;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import generalUtilities.ExcelUtilityFile;
import generalUtilities.JavaUtilityFile;
import generalUtilities.PropertyUtilityFile;

public class GenericMethodPractice {

	public static void main(String[] args) throws IOException//caller method
	{
		/*WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();*/
		
		//using property file utility
		PropertyUtilityFile putils = new PropertyUtilityFile();
		String URL = putils.readDataFromPropertyFile("url");
		System.out.println(URL);
		
		String USERNAME = putils.readDataFromPropertyFile("username");
		System.out.println(USERNAME);
		
		String PASSWORD = putils.readDataFromPropertyFile("password");
		System.out.println(PASSWORD );
		
		/*driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		
		
		////using Excel file utility
		ExcelUtilityFile Ex = new ExcelUtilityFile();
		String value = Ex.readDataFromExcel("Sheet1", 1,2);
		System.out.println(value);
		
		////using java file utility 
		JavaUtilityFile ju=new JavaUtilityFile();
		System.out.println(ju.getSystemDate());
		
		
		
}
}
