package generalUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass
{
	public PropertyUtilityFile putils = new PropertyUtilityFile();
	public ExcelUtilityFile eutils = new ExcelUtilityFile();
	public SeleniumUtility sutils = new SeleniumUtility();
	public JavaUtilityFile jutils=new JavaUtilityFile();
	
	public WebDriver driver;
	public static WebDriver sdriver;//for listeners
	
	@BeforeSuite(alwaysRun=true)
	public void bsConfig()
	{
		System.out.println("----DB connection succesful");
	}
	//@Parameters("Browser")
	//@BeforeTest
	@BeforeClass(alwaysRun=true)
	public void bcConfig() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		//if(Browser.equals("Chrome"))
		//		{
		//	driver=new ChromeDriver();
			
		//}
		//else if(Browser.equals("Edge"))
		//{
		//	driver= new EdgeDriver();
		//}
		sdriver=driver;//for listeners
		sutils.maximizeWindow(driver);
		sutils.addImplicitlyWait(driver);
		String URL = putils.readDataFromPropertyFile("url");
		driver.get(URL);
		System.out.println("----browser launched-----");
	}
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws Throwable
	{
		String USERNAME = putils.readDataFromPropertyFile("username");
		String PASSWORD = putils.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		System.out.println("----login succesful-----");
	}
	
	@AfterMethod(alwaysRun=true)
	public void amConfig() throws Throwable
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("----logout succesful-----");
	}
	//@AfterTest
	@AfterClass(alwaysRun=true)
	public void acConfig() 
	{
		driver.quit();
		System.out.println("----browser closed-----");
	}
	
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("----DB connection closed");
	}
	
	
	
	



}
