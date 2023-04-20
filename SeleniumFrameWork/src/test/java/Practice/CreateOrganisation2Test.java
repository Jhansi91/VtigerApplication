package Practice;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;
import GenericUtility.Excel_Utility;
import GenericUtility.Java_Utility;
import GenericUtility.WebDriver_Utility;
import POM.HomePage;
import POM.OrganizationsPage;
import POM.VerificationAndValidationPage;

public class CreateOrganisation2Test extends BaseClass{
	@Test
	public void createOrganisation2Test() throws Throwable {
		
		Java_Utility jlib=new Java_Utility();
		int ran_num = jlib.getRandomNum();
			
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.implicitWait(driver);
		
		Excel_Utility elib=new Excel_Utility();
		String excel_org_data = elib.getExcelData("Organizations", 0, 0)+ran_num;
		
		//creating organization
		HomePage homepage=new HomePage(driver);
		homepage.clickOrganisationsLinkText();
		
		OrganizationsPage orgpage=new OrganizationsPage(driver);
		orgpage.clickOrgCreateImg();
		orgpage.getOrgNameTxtField().sendKeys(excel_org_data);
		
		WebElement industry_DD =orgpage.getIndustryDropDown();
		
		wlib.select(industry_DD, "Energy");
		WebElement type_DD = orgpage.getTypeDropDown();
		
		wlib.select(type_DD, "Customer");
		orgpage.clickSaveButton();
				
		//verifying
		VerificationAndValidationPage valid=new VerificationAndValidationPage(driver);
		String actdata=valid.orgWithIndustryTypeValidation(excel_org_data, "Energy", "Customer");
		Assert.assertEquals(actdata, excel_org_data);
				

	}

}
