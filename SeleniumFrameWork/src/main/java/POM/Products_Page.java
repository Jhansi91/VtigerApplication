package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products_Page {
	public Products_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement procreateimg;
	@FindBy(name="productname")private WebElement prodNameTxtField;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveButton;
	@FindBy(xpath="//a[text()='Products' and @class='hdrLink']")private WebElement procductslink;
	@FindBy(xpath="//input[@class='crmbutton small delete']")private WebElement deteprodbutton;
	
	//getter methods
	public WebElement getProcreateimg() {
		return procreateimg;
	}
	public WebElement getProdNameTxtField() {
		return prodNameTxtField;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	public WebElement getProcductslink() {
		return procductslink;
	}
	public WebElement getDeteprodbutton() {
		return deteprodbutton;
	}
	//business logic
	public void clickProdCreateImg()
	{
		procreateimg.click();
	}
	public void prodNameTextField(String prodname)
	{
		prodNameTxtField.sendKeys(prodname);
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
	public void clickProductsLink()
	{
		procductslink.click();
	}
	public void deleteProduct(WebDriver driver,String proddata_del)
	{
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td/a[text()='"+proddata_del+"']/../preceding-sibling::td/input[@type='checkbox']")).click();
		deteprodbutton.click();
	}
}
