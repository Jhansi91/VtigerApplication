package Campaigns;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.Excel_Utility;
import GenericUtility.Java_Utility;
import GenericUtility.WebDriver_Utility;
import POM.CampaignsPage;
import POM.HomePage;
import POM.VerificationAndValidationPage;
//@Listeners(GenericUtility.Listeners.class)
public class CreateCampaignTest extends BaseClass {
	//@Test(groups="smoketesting")
	@Test(retryAnalyzer=GenericUtility.RetryListenerEx.class)
	public  void createCampaignTest() throws Throwable {	
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.implicitWait(driver);
		
		//generating random num
		Java_Utility jlib=new Java_Utility();
		int ran_num = jlib.getRandomNum();
			
		Excel_Utility elib=new Excel_Utility();
		String excel_camp_data = elib.getExcelDataFormatter("Campaigns", 0, 0)+ran_num;
				
		HomePage homepage=new HomePage(driver);
		homepage.moreLinkText(driver);
		homepage.clickCampaignsLinkText();
		
		//creating campaign
		CampaignsPage camppage=new CampaignsPage(driver);
		camppage.clickCampaignCreateImg();
	   	Assert.assertEquals(true, true);
		camppage.campaignNameTxtField(excel_camp_data);
		camppage.clickSaveButton();
		
		//validation
		VerificationAndValidationPage valid=new VerificationAndValidationPage(driver);
		String actcampdata=valid.campCreateValidation(excel_camp_data);
		Assert.assertEquals(actcampdata, excel_camp_data);
		
	
	}

}
