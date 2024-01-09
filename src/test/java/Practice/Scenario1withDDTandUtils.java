package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import generalUtilities.ExcelUtilityFile;
import generalUtilities.PropertyUtilityFile;
import generalUtilities.SeleniumUtility;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class Scenario1withDDTandUtils {

	public static void main(String[] args) throws Throwable 
	{
		//create object of required utility classes
		PropertyUtilityFile putils = new PropertyUtilityFile();
		ExcelUtilityFile eutils = new ExcelUtilityFile();
		SeleniumUtility sutils = new SeleniumUtility();
		
		//read common data from property file
		String URL = putils.readDataFromPropertyFile("url");
		String USERNAME = putils.readDataFromPropertyFile("username");
		String PASSWORD = putils.readDataFromPropertyFile("password");
				
	    //read testdata from excel file
		String LASTNAME =eutils.readDataFromExcel("Sheet1",1,2);
				
				//launch the base browser
				WebDriver driver=new EdgeDriver();
				sutils.maximizeWindow(driver);
				sutils.addImplicitlyWait(driver);
				
				//load the application
				driver.get(URL);
				//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				//driver.findElement(By.id("submitButton")).click();
				
				//using getters method
				//LoginPage lp = new LoginPage(driver);
				//lp.getUsernameEdt().sendKeys(USERNAME);
				//lp.getPasswordEdt().sendKeys(PASSWORD);
				//lp.getLoginBtn().click();
				
				//using business logics
				LoginPage lp = new LoginPage(driver);
				lp.LoginToApp(USERNAME, PASSWORD);
				
				
				//click on contacts link
				//driver.findElement(By.xpath("//a[text()=\"Contacts\"]")).click();
				HomePage hp=new HomePage(driver);
				hp.clickOnContactsLink();
				
				//click on create contact look image
				//driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactLookUpImage();
				
				// create new contact
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				//CreateNewContactPage cncp = new CreateNewContactPage(driver);
				//cncp.createNewContact(LASTNAME);
				
				//save
				driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
				
				//validate
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
				WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
				
				Actions act=new Actions(driver);
				act.moveToElement(ele).perform();
				
				
				driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
				
				//close the browser
				driver.quit();
				
				
				
		
	}

}
