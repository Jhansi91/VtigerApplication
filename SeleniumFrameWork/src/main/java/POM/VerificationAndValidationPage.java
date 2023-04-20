package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerificationAndValidationPage {

	public VerificationAndValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="dtlview_Organization Name")private WebElement actualOrgData;
	@FindBy(id="dtlview_Industry")private WebElement actIndustryData;
	@FindBy(id="dtlview_Type")private WebElement actTypeData;
	@FindBy(xpath="//span[@id='dtlview_Product Name']")private WebElement actualProdData;
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")private WebElement actualCampData;
	@FindBy(xpath="//span[@id='dtlview_Product']")private WebElement actualCampProdData;
	@FindBy(id="dtlview_Last Name")private WebElement actualContactData;
	@FindBy(xpath="//td[@id='mouseArea_Organization Name']//a[contains(@href,'Accounts&action')]")private WebElement actualContactOrgName;
	@FindBy(xpath="//span[@id='dtlview_Subject']")private WebElement actualinvoiceData;
	//getter methods
	public WebElement getActualOrgData() {
		return actualOrgData;
	}
	public WebElement getActIndustryData() {
		return actIndustryData;
	}
	public WebElement getActTypeData() {
		return actTypeData;
	}
	public WebElement getActualProdData() {
		return actualProdData;
	}
	public WebElement getActualCampData() {
		return actualCampData;
	}
	public WebElement getActualCampProdData() {
		return actualCampProdData;
	}
	public WebElement getActualContactData() {
		return actualContactData;
	}
	public WebElement getActualContactOrgName() {
		return actualContactOrgName;
	}
	public WebElement getActualinvoiceData() {
		return actualinvoiceData;
	}
	
	//business logic
	/**
	 * this method is used to validate whether orgnisation created as expected or not
	 * @param driver
	 * @param expected_org_data
	 * @author jhansi
	 */
	public String orgCreateValidation(String expected_org_data)
	{
		String actorgdata=actualOrgData.getText();
		if(actorgdata.equals(expected_org_data))
		{
			System.out.println("Organisation validation pass");
		}
		else
		{
			System.out.println("Organisation validation fail");
		}
		return actorgdata;
	}
/**
 * this method is used to validate the organisation with specified industry and type or not
 * @param exp_org_data
 * @param exp_indus_data
 * @param exp_type_data
 * @author jhansi
 */
	public String orgWithIndustryTypeValidation(String exp_org_data,String exp_indus_data,String exp_type_data)
	{
		String org_name=actualOrgData.getText();
		String industry=actIndustryData.getText();
		String type=actTypeData.getText();
		if(org_name.equals(exp_org_data) && industry.equals(exp_indus_data) && type.equals(exp_type_data))
		{
			System.out.println("Organisation With Industry and Type VAlidation Pass");
		}
		else
		{
			System.out.println("Organisation With Industry and Type VAlidation Fail");
		}
		return org_name;
	}
	{
		
	}
	/**
	 * this method is used to verify whether product is created as expected or not
	 * @param expectedProdData
	 * @author jhansi
	 */
	public String prodCreateValidation(String expectedProdData)
	{
		String actdata = actualProdData.getText();
		if(actdata.contains(expectedProdData))
		{
			System.out.println("Product validation pass");
		}
		else
		{
			System.out.println("Product validation fail");
		}
		return actdata; 
		
	}
	
	/**
	 * this method is used to verify whether seleted product is deleted or not
	 * @param products_list
	 * @param exp_del_data
	 * @author jhansi
	 */
	public boolean prodDeleteValidation(WebDriver driver,String exp_del_data) 
	{
		boolean flag=false;
		List<WebElement> products_list=driver.findElements(By.xpath("//table[@class='lvt small']/tbody//td/a[@title='Products']"));
		for(WebElement we:products_list)
		{
			String prod_data = we.getText();
			if(prod_data.equals(exp_del_data))
			{
				//System.out.println(prod_data+"--"+exp_del_data);
				flag=true;
				break;
			}

		}
		if(flag)
		{
			System.out.println("Product "+exp_del_data+" not deleted");
		}
		else
		{
			System.out.println("Product "+exp_del_data+" deleted successfully");
		}
		return flag;
	}
	/**
	 * this method is used to verify campaign created as expected or not
	 * @param exp_camp_data
	 * @author jhansi
	 */
	public String campCreateValidation(String exp_camp_data)
	{
		String actcampdata=actualCampData.getText();
		if(actcampdata.contains(exp_camp_data))
		{
			System.out.println("campaign validation pass");
		}
		else
		{
			System.out.println("campaign validation fail");
		}
		return actcampdata;
	}
	/**
	 * this method is used to verify whether the campaign created for the expected product or not
	 * @param exp_campprod_data
	 * @author jhansi
	 */
	public String campProdCreateValidation(String exp_campprod_data)
	{
		String actcampproddata = actualCampProdData.getText();
		if(actcampproddata.contains(exp_campprod_data))
		{
			System.out.println("product validation pass");
		}
		else
		{
			System.out.println("product validation Fail");
		}
		return actcampproddata;
	}
	public String contactCreateValidation(String exp_contact_data,String exp_contactorg_data)
	{
		String actContData = actualContactData.getText();
		String actContOrgData = actualContactOrgName.getText();
		if(actContData.equals(exp_contact_data) && actContOrgData.equals(exp_contactorg_data))
		{
			System.out.println("Contact validation pass");
		}
		else
		{
			System.out.println("Contact validation fail");
		}
		return actContData;
	}
	public void invoiceCreateValidation(String exp_invoice_data)
	{
		String invoice_saved = actualinvoiceData.getText();
		if(invoice_saved.equals(exp_invoice_data))
		{
			System.out.println("invoice generated and validation pass");
		}
		else
		{
			System.out.println("invoice not generated and validation Fail");
		}
	}
}
