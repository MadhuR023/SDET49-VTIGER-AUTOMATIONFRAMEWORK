package VtigerPomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(linkText = "Calendar") private WebElement calendarBtnClk;
	@FindBy(linkText = "Leads") private WebElement leadsBtnClk;
	@FindBy(linkText = "Organizations") private WebElement OrganizationBtnClk;
	@FindBy(linkText = "Contacts") private WebElement contactsBtnClk;
	@FindBy(xpath = "//td[@class='small']/table/tbody/tr/td[2]") private WebElement LogoutBtnClk;
	@FindBy(linkText = "Sign Out") private WebElement SignoutDropDownClk;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCalendarBtnClkElement() {
		return calendarBtnClk;
	}

	public WebElement getLeadsBtnClk() {
		return leadsBtnClk;
	}

	public WebElement getOrganizationBtnClk() {
		return OrganizationBtnClk;
	}

	public WebElement getContactsBtnClk() {
		return contactsBtnClk;
	}
		
	public WebElement getLogoutBtnClk() {
		return LogoutBtnClk;
	}

	public void calendarBtn() {
		calendarBtnClk.click();
	}
	
	public void leadsBtn() {
		leadsBtnClk.click();
	}
	
	public void organizationBtn() {
		OrganizationBtnClk.click();		
	}
	
	public void contactsBtn() {
		contactsBtnClk.click();
	}
	
	public void logoutBtnClk() {
		LogoutBtnClk.click();
		SignoutDropDownClk.click();
	}
	
}
