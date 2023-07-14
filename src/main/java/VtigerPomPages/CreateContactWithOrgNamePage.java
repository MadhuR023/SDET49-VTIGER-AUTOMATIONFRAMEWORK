package VtigerPomPages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vtiger.GenericUtilities.WebDriverUtility;

public class CreateContactWithOrgNamePage {
	WebDriverUtility wutil=new WebDriverUtility();
	@FindBy(xpath = "//img[@alt='Create Contact...']") private WebElement createContactBtnClk;
	@FindBy(name = "lastname") private WebElement contactLastNameEdtTxt;
	@FindBy(xpath = "//tbody/tr[5]/td[2]/img[@title='Select']") private WebElement selectOrganizationBnClk;
	@FindBy(id = "search_txt")private WebElement searchOrgNameEdtTxt;
	@FindBy(name = "search") private WebElement searchBtnClk;
	@FindBy(id = "1") private WebElement orgNameSelectBtnClk;
	@FindBy(xpath = "//input[@title=\\\"Save [Alt+S]\\\"]") private WebElement saveBtnClk;
	
	public CreateContactWithOrgNamePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactBtnClk() {
		return createContactBtnClk;
	}

	public WebElement getContactLastNameEdtTxt() {
		return contactLastNameEdtTxt;
	}

	public WebElement getSelectOrganizationBnClk() {
		return selectOrganizationBnClk;
	}

	public WebElement getSearchOrgNameEdtTxt() {
		return searchOrgNameEdtTxt;
	}

	public WebElement getSearchBtnClk() {
		return searchBtnClk;
	}

	public WebElement getOrgNameSelectBtnClk() {
		return orgNameSelectBtnClk;
	}

	public WebElement getSaveBtnClk() {
		return saveBtnClk;
	}
	
	public void createContactWithOrgName(WebDriver driver, String lastName, String Orgname) throws InterruptedException {
		
		createContactBtnClk.click();
		contactLastNameEdtTxt.sendKeys(lastName);
		selectOrganizationBnClk.click();
		wutil.switchToWindow(driver, "Organizations");
		searchOrgNameEdtTxt.sendKeys(Orgname);
		searchBtnClk.click();
		Thread.sleep(1000);
		orgNameSelectBtnClk.click();
		wutil.switchToWindow(driver, "Contacts ");
		Thread.sleep(1000);
		saveBtnClk.click();		
	}
}
