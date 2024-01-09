package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage
{
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement contactHeaderText;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getcontactHeader() 
	{
		return contactHeaderText;
	}
	//business library
/**
 * this method will capture the header text and return it to caller
 * @return
 */
	public String captureHeaderText()
	{
		return contactHeaderText.getText();
		
	}

}
