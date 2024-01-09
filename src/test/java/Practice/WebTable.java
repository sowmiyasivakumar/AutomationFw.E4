package Practice;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import generalUtilities.ExcelUtilityFile;
import generalUtilities.PropertyUtilityFile;
import generalUtilities.SeleniumUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class WebTable {

	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//create object of required utility classes
				PropertyUtilityFile putils = new PropertyUtilityFile();
				ExcelUtilityFile eutils = new ExcelUtilityFile();
				SeleniumUtility sutils = new SeleniumUtility();
				
				//read common data from property file
				String URL = putils.readDataFromPropertyFile("url");
				String USERNAME = putils.readDataFromPropertyFile("username");
				String PASSWORD = putils.readDataFromPropertyFile("password");
				
				//login to app
				driver.get(URL);	
				LoginPage lp = new LoginPage(driver);
				lp.LoginToApp(USERNAME, PASSWORD);
				
				//click on contactslink
				HomePage hp=new HomePage(driver);
				hp.clickOnContactsLink();
				/*
				//scenario 1:check on all the check boxes
				
				//find using syntax(starting from table)
				List<WebElement> allcheckbox = driver.findElements(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[*]/td[1]/input"));
                
				//find directly
				List<WebElement> allcheckbox = driver.findElements(By.xpath("//input[@name=\"selected_id\"]"));
				int count=0;
				for(WebElement allcheck:allcheckbox)
                {
                	allcheck.click();
                	count++;
                }
				System.out.println("total count is"+count);
				
				//scenario 2:check on 5th check box
				driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[position()=5]")).click();//direct approach
				//driver.findElement(By.xpath("(//table[@class=\"lvt small\"]/tbody/tr[6]/td[1]/input)")).click();//syntax
				
				//scenario 3:capture all the last names and print in console
				List<WebElement> allLastname = driver.findElements(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[*]/td[4]/a"));
			//List<WebElement> allLastname = driver.findElements(By.xpath("//a[@title=\"Contacts\"]"));
				for(WebElement allLast:allLastname)
				{
					System.out.println(allLast.getText());
				}
				
				//scenario 4:click on the last check box
				driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[last()]")).click();
				*/
				//scenario 5:click on the 6th check box and capture the contact and delete the contact
				driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[position()=6]")).click();
				String name = driver.findElement(By.xpath("(//a[@title=\"Contacts\"])[position()=10]")).getText();
				System.out.println(name);
				driver.findElement(By.xpath("(//a[text()=\"del\"])[position()=5]")).click();
			     Alert alt = driver.switchTo().alert();
			     String s=alt.getText();
			     System.out.println(s);
			     alt.accept();
                
				
	}

}
