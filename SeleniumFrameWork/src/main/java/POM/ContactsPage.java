package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")private WebElement contactCreateImg;
	@FindBy(name="lastname")private WebElement contactNameTxtField;
	@FindBy(xpath="//img[@title='Select' and contains(@onclick,'Accounts')]")private WebElement selectOrgImg;
	@FindBy(name="search_text")private WebElement searchOrgTxtField;
	@FindBy(name="search")private WebElement searchBtn;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement savebutton;
	public WebElement getContactCreateImg() {
		return contactCreateImg;
	}
	public WebElement getContactNameTxtField() {
		return contactNameTxtField;
	}
	public WebElement getSelectOrgImg() {
		return selectOrgImg;
	}
	public WebElement getSearchOrgTxtField() {
		return searchOrgTxtField;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getSavebutton() {
		return savebutton;
	}
	
	//business logic
	public void clickContactCreateImg()
	{
		contactCreateImg.click();
	}
	public void contactNameTxtField(String contactName)
	{
		contactNameTxtField.sendKeys(contactName);
	}
	public void clickSelectOrgImg()
	{
		selectOrgImg.click();
	}
	public void searchOrgTxtField(String orgName)
	{
		searchOrgTxtField.sendKeys(orgName);
	}
	public void clickSearchBtn()
	{
		searchBtn.click();
	}
	public void selectOrgInSearchPage(WebDriver driver,String orgname)
	{
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
	}
	public void clickSaveButton()
	{
		savebutton.click();
	}
}
