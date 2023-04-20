package Organizations;
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

public class CreateOrganizationTest extends BaseClass{
	@Test(groups="regressiontesting")
	public void createOrganizationTest() throws Throwable {
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.implicitWait(driver);
		
		//creating random class and generating random num
		Java_Utility jlib=new Java_Utility();
		int ran_num = jlib.getRandomNum();
		
		//reading data from excel
		Excel_Utility elib=new Excel_Utility();
		String Excel_data = elib.getExcelData("Organizations", 0, 0)+ran_num;
		
		HomePage homepage=new HomePage(driver);
		homepage.clickOrganisationsLinkText();
		
		OrganizationsPage orgpage=new OrganizationsPage(driver);
		orgpage.clickOrgCreateImg();
		orgpage.getOrgNameTxtField().sendKeys(Excel_data);
		orgpage.clickSaveButton();
		
		VerificationAndValidationPage validate=new VerificationAndValidationPage(driver);
		String actdata = validate.orgCreateValidation(Excel_data);
		Assert.assertEquals(actdata, Excel_data);
		
		
	}
	
	
	/*
	 * @Test public void createOrganisation2Test() throws Throwable {
	 * 
	 * Java_Utility jlib=new Java_Utility(); int ran_num = jlib.getRandomNum();
	 * 
	 * WebDriver_Utility wlib=new WebDriver_Utility(); wlib.implicitWait(driver);
	 * 
	 * Excel_Utility elib=new Excel_Utility(); String excel_org_data =
	 * elib.getExcelData("Organizations", 0, 0)+ran_num;
	 * 
	 * //creating organization HomePage homepage=new HomePage(driver);
	 * homepage.clickOrganisationsLinkText();
	 * 
	 * OrganizationsPage orgpage=new OrganizationsPage(driver);
	 * orgpage.clickOrgCreateImg();
	 * orgpage.getOrgNameTxtField().sendKeys(excel_org_data);
	 * 
	 * WebElement industry_DD =orgpage.getIndustryDropDown();
	 * 
	 * wlib.select(industry_DD, "Energy"); WebElement type_DD =
	 * orgpage.getTypeDropDown();
	 * 
	 * wlib.select(type_DD, "Customer"); orgpage.clickSaveButton();
	 * 
	 * //verifying VerificationAndValidationPage valid=new
	 * VerificationAndValidationPage(driver);
	 * valid.orgWithIndustryTypeValidation(excel_org_data, "Energy", "Customer");
	 * 
	 * 
	 * }
	 */
	 


}
