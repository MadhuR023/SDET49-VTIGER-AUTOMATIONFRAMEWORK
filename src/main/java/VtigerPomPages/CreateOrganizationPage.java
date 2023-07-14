package VtigerPomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	@FindBy(xpath = "//img[@alt='Create Organization...']") private WebElement organizationBtnClk;
	@FindBy(name = "accountname") private WebElement orgNameEdtTxt;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']") private WebElement saveBtnClk;
	
	public CreateOrganizationPage(WebDriver driver) {
		 PageFactory.initElements(driver,this);
	}
	
	public WebElement getOrganizationBtnClk() {
		return organizationBtnClk;
	}

	public WebElement getOrgNameEdtTxt() {
		return orgNameEdtTxt;
	}

	public WebElement getSaveBtnClk() {
		return saveBtnClk;
	}
	
public void createOrganization(String orgName) {
	organizationBtnClk.click();
	orgNameEdtTxt.sendKeys(orgName);
	saveBtnClk.click();		
	}
}
