package Products;

import org.testng.Assert;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;
import GenericUtility.Excel_Utility;
import GenericUtility.Java_Utility;
import GenericUtility.WebDriver_Utility;
import POM.HomePage;
import POM.Products_Page;
import POM.VerificationAndValidationPage;

public class CreateProductTest extends BaseClass{
	@Test(groups={"sanitytesting","smoketesting"})
	public void createProductTest() throws Throwable {
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.implicitWait(driver);
		
		//random class
		Java_Utility jlib=new Java_Utility();
		int ran_num = jlib.getRandomNum();
		
		Excel_Utility elib=new Excel_Utility();
		String excel_prod_data = elib.getExcelData("Products", 0, 0)+ran_num;
		
		//click products link
		HomePage homepage=new HomePage(driver);
		homepage.clickProductsLinkText();
		
		//create product
		Products_Page prodpage=new Products_Page(driver);
		prodpage.clickProdCreateImg();
		prodpage.prodNameTextField(excel_prod_data);
		prodpage.clickSaveButton();
		
		//validation		
		VerificationAndValidationPage validation=new VerificationAndValidationPage(driver);	
		String actproddata=validation.prodCreateValidation(excel_prod_data);
		Assert.assertEquals(actproddata, excel_prod_data);
		
		
	}

}
