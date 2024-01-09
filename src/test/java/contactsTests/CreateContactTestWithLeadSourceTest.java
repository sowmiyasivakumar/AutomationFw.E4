package contactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generalUtilities.BaseClass;
import generalUtilities.ExcelUtilityFile;
import generalUtilities.PropertyUtilityFile;
import generalUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
@Listeners(generalUtilities.ListenersImplementation.class)
public class CreateContactTestWithLeadSourceTest extends BaseClass
{
@Test(groups="RegressionSuite")
	public void createNewContactwithLeadSourceValue() throws Throwable
	{
		               //read testdata from excel file
				       String LASTNAME =eutils.readDataFromExcel("Sheet1",1,2);
				       String LEADSOURCEVALUE = eutils.readDataFromExcel("Sheet1",4,3);
						
                        //click on contacts link
						HomePage hp=new HomePage(driver);
						hp.clickOnContactsLink();
						
				        //click on create contact look image
						ContactsPage cp = new ContactsPage(driver);
						cp.clickOnCreateContactLookUpImage();
						
						// create new contact and save
						CreateNewContactPage cncp = new CreateNewContactPage(driver);
						cncp.createNewContact(LASTNAME, LEADSOURCEVALUE);
						
						//validate
						ContactInfoPage cip = new ContactInfoPage(driver);
						String contactheader = cip.captureHeaderText();
						
						Assert.assertTrue(contactheader.contains(LASTNAME));
						System.out.println(contactheader);
						
		

	}

}
