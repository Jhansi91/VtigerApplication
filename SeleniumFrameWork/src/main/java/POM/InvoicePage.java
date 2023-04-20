package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {
	public InvoicePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Invoice...']")private WebElement createInvoiceImg;
	@FindBy(name="subject")private WebElement subjectTxtField;
	@FindBy(xpath="//img[@title='Select' and contains(@onclick,'selectContact')]")private WebElement selectContactImg;
	@FindBy(xpath="//img[@title='Select' and contains(@onclick,'Accounts&action')]")private WebElement selectOrgImg;
	@FindBy(name="search_text")private WebElement searchTxtField;
	@FindBy(name="search")private WebElement searchButton;
	@FindBy(name="bill_street")private WebElement billingAddTxtField;
	@FindBy(name="ship_street")private WebElement shippingAddTxtField;
	@FindBy(id="searchIcon1")private WebElement prodSearchImg;
	@FindBy(id="qty1")private WebElement qtyTxtField;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveButton;
	
	//getters
	public WebElement getCreateInvoiceImg() {
		return createInvoiceImg;
	}
	public WebElement getSubjectTxtField() {
		return subjectTxtField;
	}
	public WebElement getSelectContactImg() {
		return selectContactImg;
	}
	public WebElement getSelectOrgImg() {
		return selectOrgImg;
	}
	public WebElement getSearchTxtField() {
		return searchTxtField;
	}
	public WebElement getSearchButton() {
		return searchButton;
	}
	public WebElement getBillingAddTxtField() {
		return billingAddTxtField;
	}
	public WebElement getShippingAddTxtField() {
		return shippingAddTxtField;
	}
	public WebElement getProdSearchImg() {
		return prodSearchImg;
	}
	public WebElement getQtyTxtField() {
		return qtyTxtField;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//business logic
	
	public void clickCreateInvoiceImg() 
	{
		createInvoiceImg.click();
	}
	
	
	public void subjectTxtField(String subname) {
		subjectTxtField.sendKeys(subname);;
	}
	public void clickSelectContactImg() {
		selectContactImg.click();;
	}
	public void clickSelectOrgImg() {
		selectOrgImg.click();;
	}
	public void clickSearchButton() {
		searchButton.click();;
	}
	public void billingAddTxtField(String billingadd) {
		 billingAddTxtField.sendKeys(billingadd);;
	}
	public void shippingAddTxtField(String shippadd) {
		shippingAddTxtField.sendKeys(shippadd);;
	}
	public void clickProdSearchImg() {
		prodSearchImg.click();;
	}
	public void selectData(WebDriver driver,String data)
	{
		driver.findElement(By.xpath("//a[text()='"+data+"']")).click();
	}
	public void qtyTxtField(String qty) {
		qtyTxtField.sendKeys(qty);;
	}
	public void clickSaveButton() {
		saveButton.click();;
	}
	

	
	
}
