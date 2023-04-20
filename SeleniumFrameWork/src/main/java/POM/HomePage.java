package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriver_Utility;

public class HomePage {
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations") private WebElement organizationslink;
	@FindBy(linkText="Contacts") private WebElement contactslink;
	@FindBy(linkText="Products") private WebElement productslink;
	@FindBy(linkText="More") private WebElement morelink;
	@FindBy(linkText="Campaigns")private WebElement campaignslink;
	@FindBy(linkText="Invoice")private WebElement invoicelink;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")private WebElement useracntimg;
	@FindBy(xpath="//a[.='Sign Out']")private WebElement signoutlink;
	
	
	
	public WebElement getOrganizationsLink() {
		return organizationslink;
	}

	public WebElement getContactsLink() {
		return contactslink;
	}

	public WebElement getProductsLink() {
		return productslink;
	}

	public WebElement getMoreLink() {
		return morelink;
	}
	
	public WebElement getCampaignslink() {
		return campaignslink;
	}

	public WebElement getInvoicelink() {
		return invoicelink;
	}

	public WebElement getUseracntlink() {
		return useracntimg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}

	
	public void clickOrganisationsLinkText()
	{
		organizationslink.click();
	}
	
	public void clickContactsLinkText()
	{
		contactslink.click();
	}
    
	public void clickProductsLinkText()
	{
		productslink.click();
	}
	public void moreLinkText(WebDriver driver)
	{
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.mouseOverOnElement(driver,morelink);
	}
	public void clickCampaignsLinkText()
	{
		campaignslink.click();
	}
	public void clickInvoiceLinkText()
	{
		invoicelink.click();
	}
	public void signoutLink(WebDriver driver)
	{
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.mouseOverOnElement(driver,useracntimg);
		signoutlink.click();
	}
    
}
