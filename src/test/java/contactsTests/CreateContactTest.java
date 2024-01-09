package contactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generalUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
@Listeners(generalUtilities.ListenersImplementation.class)
public class CreateContactTest extends BaseClass
{
	@Test(groups="SmokeSuite")
	public void createcontact() throws Throwable, IOException
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
			cncp.createNewContact(LASTNAME);
			
			
			//validate
			ContactInfoPage cip = new ContactInfoPage(driver);
			String contactheader = cip.captureHeaderText();
			
			Assert.assertTrue(contactheader.contains(LASTNAME));
			System.out.println(contactheader);
			


		
	}

}
