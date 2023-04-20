package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;
import GenericUtility.Excel_Utility;
import GenericUtility.WebDriver_Utility;
import POM.ContactsPage;
import POM.HomePage;
import POM.VerificationAndValidationPage;

public class CreateContactTest extends BaseClass{
	@Test
	public void createContactTest() throws Throwable {
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.maximizeBrowser(driver);
		wlib.implicitWait(driver);
			
		Excel_Utility elib=new Excel_Utility();
		String excel_contact_data = elib.getExcelData("Contacts", 0, 0);
		String excel_org_data = elib.getExcelData("Organizations", 0, 0);
		
		HomePage homepage=new HomePage(driver);
		homepage.clickContactsLinkText();
		
		ContactsPage contctpage=new ContactsPage(driver);
		contctpage.clickContactCreateImg();
		contctpage.contactNameTxtField(excel_contact_data);
		contctpage.clickSelectOrgImg();
		
		wlib.switchWindow(driver, "Accounts&action");
		contctpage.searchOrgTxtField(excel_org_data);
		contctpage.clickSearchBtn();
		
		contctpage.selectOrgInSearchPage(driver, excel_org_data);
		wlib.switchWindow(driver, "Contacts&action");
		contctpage.clickSaveButton();
		
		//validation
		VerificationAndValidationPage valid=new VerificationAndValidationPage(driver);
		String actContData=valid.contactCreateValidation(excel_contact_data, excel_org_data);
		Assert.assertEquals(actContData, excel_contact_data);
	}

}
