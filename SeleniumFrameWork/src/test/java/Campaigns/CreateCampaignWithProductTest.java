package Campaigns;

import org.testng.Assert;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;
import GenericUtility.Excel_Utility;
import GenericUtility.Java_Utility;
import GenericUtility.WebDriver_Utility;
import POM.CampaignsPage;
import POM.HomePage;
import POM.Products_Page;
import POM.VerificationAndValidationPage;


public class CreateCampaignWithProductTest extends BaseClass{
	@Test(groups="sanitytesting")
	public void createCampaignWithProductTest() throws Throwable {
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.implicitWait(driver);
				
		Java_Utility jlib=new Java_Utility();
		int ran_num = jlib.getRandomNum();
		
		Excel_Utility elib=new Excel_Utility();
		String excel_prod_data = elib.getExcelData("Products", 0, 0)+ran_num;
		String excel_camp_data = elib.getExcelData("Campaigns", 0, 0)+ran_num;
		
		//creating product
		HomePage homepage=new HomePage(driver);
		homepage.clickProductsLinkText();
		Products_Page prodpage=new Products_Page(driver);
		prodpage.clickProdCreateImg();
		prodpage.prodNameTextField(excel_prod_data);
		prodpage.clickSaveButton();
		
		//creating campaign
		homepage.moreLinkText(driver);
		homepage.clickCampaignsLinkText();
		
		CampaignsPage camppage=new CampaignsPage(driver);
		camppage.clickCampaignCreateImg();
		camppage.campaignNameTxtField(excel_camp_data);
		
		//selecting created product for campaign
		camppage.clickSelectProductImg();
		wlib.switchWindow(driver, "Products&action");
		camppage.searchProductTxtField(excel_prod_data);
		camppage.clickSearchBtn();
		camppage.searchProdInSearchPage(driver, excel_prod_data);
			
		wlib.switchWindow(driver, "Campaigns&action");
		camppage.clickSaveButton();
		
		VerificationAndValidationPage campvalid=new VerificationAndValidationPage(driver);
		String actcampdata=campvalid.campCreateValidation(excel_camp_data);
		String actcampproddata=campvalid.campProdCreateValidation(excel_prod_data);
		Assert.assertEquals(actcampdata, excel_camp_data);
		Assert.assertEquals(actcampproddata, excel_prod_data);
		
		
		
		
	}

}
