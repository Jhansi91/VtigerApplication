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
public class CreateAndDeleteProductTest extends BaseClass {
	@Test(groups={"smoketesting","regressiontesting"})
	public void createAndDeleteProductTest() throws Throwable {
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.implicitWait(driver);

		Java_Utility jlib=new Java_Utility();
		int ran_num = jlib.getRandomNum();

		Excel_Utility elib=new Excel_Utility();
		String excel_prod_data = elib.getExcelData("Products", 0, 0)+ran_num;

		HomePage homepage=new HomePage(driver);
		homepage.clickProductsLinkText();
		
		//creating product
		Products_Page prodpage=new Products_Page(driver);
		prodpage.clickProdCreateImg();
		prodpage.prodNameTextField(excel_prod_data);
		prodpage.clickSaveButton();
		
		//validating whether product created or not
		VerificationAndValidationPage validate=new VerificationAndValidationPage(driver);
		String actdata=validate.prodCreateValidation(excel_prod_data);
		Assert.assertEquals(actdata, excel_prod_data);

		//delete product
		prodpage.clickProductsLink();
		prodpage.deleteProduct(driver, excel_prod_data);;
		wlib.switchToAlertAndAccept(driver);
		
		//verifying whether product deleted or not
		prodpage.clickProductsLink();
		VerificationAndValidationPage delvalid=new VerificationAndValidationPage(driver);
		boolean flag=delvalid.prodDeleteValidation(driver, excel_prod_data);
		Assert.assertEquals(flag, false);


	}

}
