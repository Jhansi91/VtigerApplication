package Practice;

import org.testng.annotations.Test;
import GenericUtility.BaseClass;
import GenericUtility.Excel_Utility;
import GenericUtility.Java_Utility;
import GenericUtility.WebDriver_Utility;
import POM.HomePage;
import POM.InvoicePage;
import POM.VerificationAndValidationPage;
public class CreateInvoiceTest extends BaseClass {
	@Test
	public void createInvoiceTest() throws Throwable {		
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.maximizeBrowser(driver);
		wlib.implicitWait(driver);
		
		Java_Utility jlib=new Java_Utility();
		int rannum = jlib.getRandomNum();
		
		Excel_Utility elib=new Excel_Utility();
		String invoice_subject = elib.getExcelDataFormatter("Invoice", 0, 0)+rannum;
		String bill_address = elib.getExcelDataFormatter("Invoice", 0, 1);
		String qty = elib.getExcelDataFormatter("Invoice", 0, 2);
		String contact_data = elib.getExcelDataFormatter("Contacts", 0, 0);
		String org_data = elib.getExcelDataFormatter("Organizations", 0, 0);
		
		String prod_data = elib.getExcelDataFormatter("Products", 0, 0);
		
		
		HomePage homepage=new HomePage(driver);
		homepage.moreLinkText(driver);
		homepage.clickInvoiceLinkText();
		InvoicePage invoicepg=new InvoicePage(driver);
		invoicepg.clickCreateInvoiceImg();
		invoicepg.subjectTxtField(invoice_subject);
		invoicepg.clickSelectContactImg();
		
		wlib.switchWindow(driver, "Contacts&action");
		invoicepg.getSearchTxtField().sendKeys(contact_data);
		invoicepg.clickSearchButton();
		invoicepg.selectData(driver, " "+contact_data);
		wlib.switchToAlertAndAccept(driver);
		
		wlib.switchWindow(driver, "Invoice&action");
		invoicepg.clickSelectOrgImg();
	
		wlib.switchWindow(driver, "Accounts&action");
		invoicepg.getSearchTxtField().sendKeys(org_data);
		invoicepg.clickSearchButton();
		invoicepg.selectData(driver, org_data);
		wlib.switchToAlertAndAccept(driver);
		
		wlib.switchWindow(driver, "Invoice&action");
		invoicepg.billingAddTxtField(bill_address);
		invoicepg.shippingAddTxtField(bill_address);
		invoicepg.clickProdSearchImg();
		
		wlib.switchWindow(driver, "Products&action");
		invoicepg.getSearchTxtField().sendKeys(prod_data);
		invoicepg.clickSearchButton();
		invoicepg.selectData(driver, prod_data);
		
		wlib.switchWindow(driver, "Invoice&action");
		invoicepg.qtyTxtField(qty);
		invoicepg.clickSaveButton();
		
		VerificationAndValidationPage valid=new VerificationAndValidationPage(driver);
		valid.invoiceCreateValidation(invoice_subject);

		
	}

}
