package VtigerPomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement orgNameTxt;
	
public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
}

public WebElement getOrgNameTxt() {
	return orgNameTxt;
}

public String orgnameverify() {
	return orgNameTxt.getText();
	
}

}
