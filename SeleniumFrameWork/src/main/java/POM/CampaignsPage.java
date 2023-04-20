package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='Create Campaign...']")private WebElement campaigncreateimg;
	@FindBy(name="campaignname")private WebElement campaignNameTxtField;
	@FindBy(xpath="//img[@title='Select']")private WebElement selectProductImg;
	@FindBy(name="search_text")private WebElement searchProductTxtField;
	@FindBy(name="search")private WebElement searchBtn;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveButton;
	
	//getter methods
	public WebElement getCampaigncreateimg() {
		return campaigncreateimg;
	}
	public WebElement getCampaignNameTxtField() {
		return campaignNameTxtField;
	}
	public WebElement getSelectProductImg() {
		return selectProductImg;
	}
	public WebElement getSearchProductTxtField() {
		return searchProductTxtField;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//business logic
	public void clickCampaignCreateImg()
	{
		campaigncreateimg.click();
	}
	public void campaignNameTxtField(String campaignname)
	{
		campaignNameTxtField.sendKeys(campaignname);
	}
	public void clickSelectProductImg()
	{
		selectProductImg.click();
	}
	public void searchProductTxtField(String productname)
	{
		searchProductTxtField.sendKeys(productname);
	}
	public void clickSearchBtn()
	{
		searchBtn.click();
	}
	public void searchProdInSearchPage(WebDriver driver,String prodname)
	{
		driver.findElement(By.xpath("//a[text()='"+prodname+"']")).click();
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
}
