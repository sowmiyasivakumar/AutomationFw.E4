package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generalUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility
{
	//identification
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	private WebElement saveBtn;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	

	//initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getlastnameEdt() 
	{
		return lastnameEdt;
	}
	public WebElement getsaveBtn() 
	{
		return saveBtn;
	}
	public WebElement getLeadSourceDropDown() 
	{
		return leadSourceDropDown;
	}

	
	//business libraries
	/**
	 * this method will create new contact and save it
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		lastnameEdt.sendKeys(LASTNAME);
		saveBtn.click();
		
	}
	/**
	 * this method will create new contact and select value to leadsource dropdown and save it
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME,String LEADSOURCEVALUE)
	{
		lastnameEdt.sendKeys(LASTNAME);
		handleDropDown(leadSourceDropDown,LEADSOURCEVALUE);
		saveBtn.click();
		
	}
	
}
