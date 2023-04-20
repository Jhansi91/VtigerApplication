package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
public OrganizationsPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//img[contains(@title,'Create Organization')]")
private WebElement orgcreateimage;
@FindBy(name="accountname") private WebElement orgNameTxtField;
@FindBy(name="industry")private WebElement industryDropDown;
@FindBy(name="accounttype")private WebElement typeDropDown;
@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement saveButton;

public WebElement getOrgcreateimage() {
	return orgcreateimage;
}
public WebElement getOrgNameTxtField() {
	return orgNameTxtField;
}
public WebElement getSaveButton() {
	return saveButton;
}
public WebElement getIndustryDropDown() {
	return industryDropDown;
}
public WebElement getTypeDropDown() {
	return typeDropDown;
}
//business logic
public void clickOrgCreateImg()
{
	orgcreateimage.click();
}
public void orgnameTxtField(String orgName)
{
	orgNameTxtField.sendKeys(orgName);
}
public void clickSaveButton()
{
	saveButton.click();
}

}

