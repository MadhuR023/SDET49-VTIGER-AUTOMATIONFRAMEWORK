package VTigerPomTestNG;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtilities;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import VtigerPomPages.CreateOrganizationPage;
import VtigerPomPages.HomePage;
import VtigerPomPages.LoginPage;
import VtigerPomPages.OrganizationInfoPage;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(Vtiger.GenericUtilities.ITestListnersImplementation.class)
public class CreateOrganizationTest {
	
	@Test
public void createOrganizationTest() throws IOException {
	// Create all Objects
	ExcelFileUtility eutil = new ExcelFileUtility();
	JavaUtilities jutil = new JavaUtilities();
	PropertyFileUtility putil = new PropertyFileUtility();
	WebDriverUtility wutil = new WebDriverUtility();

	// Generate Random Number
	int rnum = jutil.getRandomNumber();

	// Read Data From PropertyFile
	String BROWSER = putil.readFromPropertyFile("browser");
	String URL = putil.readFromPropertyFile("url");
	String USERNAME = putil.readFromPropertyFile("username");
	String PASSWORD = putil.readFromPropertyFile("password");

	// Read Data From ExcelFile
	String ORGNAME = eutil.readFromExcel("Contacts", 4, 3);

	// Launch Browser
	WebDriver driver = null;

	if (BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	} else if (BROWSER.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

	} else {
		System.out.println("Invalid Browser");
	}
	wutil.maximizeWindow(driver);
	wutil.waitForPageLoad(driver);
	driver.get(URL);

	// Login to App
	LoginPage loginPage = new LoginPage(driver);
	loginPage.loginToApp(USERNAME, PASSWORD);

	// Click on Organizations Link
	HomePage homePage = new HomePage(driver);
	homePage.organizationBtn();

	// Create new Organization
	CreateOrganizationPage createOrganization = new CreateOrganizationPage(driver);
	createOrganization.createOrganization(ORGNAME+rnum);

	// Verify Orgname
	OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
	String finaltext = orgInfo.orgnameverify();

	if (finaltext.contains(ORGNAME+rnum)) {
		System.out.println("Organization " + ORGNAME+rnum + " created. Test pass");
	}

	else {
		System.out.println("Test Fail");

	}
		
}		
	
			
}
