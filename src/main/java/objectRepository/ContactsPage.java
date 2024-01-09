package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
	@FindBy(xpath="//img[@title=\"Create Contact...\"]")
	private WebElement contactlookimg;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getcontactlookimg() 
	{
		return contactlookimg;
	}
	//business library
	/**
	 * this method will click on create contact look image
	 */
	public void clickOnCreateContactLookUpImage()
	{
		contactlookimg.click();
	}

}
