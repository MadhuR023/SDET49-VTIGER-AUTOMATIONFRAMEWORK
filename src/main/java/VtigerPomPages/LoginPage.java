package VtigerPomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declaration
	@FindBy(name = "user_name") private WebElement usrNameEdtTxt;
	@FindBy(name = "user_password") private WebElement usrPasswordEdtTxt;
	@FindBy(id = "submitButton") private WebElement submitBtn;
	
	//Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getUsrNameEdtTxt() {
		return usrNameEdtTxt;
	}

	public WebElement getUsrPasswordEdtTxt() {
		return usrPasswordEdtTxt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//Business Libraries
	public void loginToApp(String userName, String passWord) {
		usrNameEdtTxt.sendKeys(userName);
		usrPasswordEdtTxt.sendKeys(passWord);
		submitBtn.click();
		
	}

}
