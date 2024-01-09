package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generalUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility
{
	//identification
	@FindBy(xpath="//a[text()=\"Contacts\"]")
	private WebElement contactlnk;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administratorImagelnk;
	
	@FindBy(xpath="//a[text()=\"Sign Out\"]")
	private WebElement signoutlnk;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getadministratorImagelnk() {
		return administratorImagelnk;
	}

	public WebElement getSignoutlnk() {
		return signoutlnk;
	}

	public WebElement getContactlnk() 
	{
		return contactlnk;
	}
	//business logics
	/**
	 * this method will perform click action on contact link
	 */
	public void clickOnContactsLink()
	{
		contactlnk.click();
	}
	/**
	 * this method will perform signout operation
	 * @param driver
	 * @throws Throwable
	 */
	public void logoutOfApp(WebDriver driver) throws Throwable
	{
		mouseOverAction(driver,administratorImagelnk);
		Thread.sleep(1000);
		signoutlnk.click();
		
		
	}
	
	

}
