package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class DataDrivenTesting {

	public static void main(String[] args) throws IOException 
	{
		//read common data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		//read testdata from excel file
		FileInputStream fisE = new FileInputStream("D:\\Backup\\Documents\\TestData.xlsx");
		Workbook book = WorkbookFactory.create(fisE);
		String LASTNAME = book.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		
		//launch the base browser
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//load the application
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//click on contacts link
		driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
		
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		
		String contactheader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		
		if(contactheader.contains(LASTNAME))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		//logout
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
		
		//close the browser
		driver.quit();
		
		
		

	}

}
