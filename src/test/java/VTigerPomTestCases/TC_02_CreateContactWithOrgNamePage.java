package VTigerPomTestCases;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtilities;
import Vtiger.GenericUtilities.PropertyFileUtility;
import Vtiger.GenericUtilities.WebDriverUtility;
import VtigerPomPages.CreateContactPage;
import VtigerPomPages.CreateContactWithOrgNamePage;
import VtigerPomPages.CreateOrganizationPage;
import VtigerPomPages.HomePage;
import VtigerPomPages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_02_CreateContactWithOrgNamePage {

	public static void main(String[] args) throws InterruptedException, IOException {
		//Create all Objects
		ExcelFileUtility eutil=new ExcelFileUtility();
		JavaUtilities jutil=new JavaUtilities();
		PropertyFileUtility putil=new PropertyFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		
		//Generate Random Number
		int rnum = jutil.getRandomNumber();
		
		//Read Data From PropertyFile 
		String BROWSER = putil.readFromPropertyFile("browser");
		String URL = putil.readFromPropertyFile("url");
		String USERNAME=putil.readFromPropertyFile("username");
		String PASSWORD = putil.readFromPropertyFile("password");
		
		//Read Data From ExcelFile 
		String LASTNAME = eutil.readFromExcel("Contacts", 4, 2);
		String ORGNAME=eutil.readFromExcel("Contacts", 4, 3);
		
	
		//Launch Browser
		WebDriver driver=null;
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		} 
		else {
			System.out.println("Invalid Browser");
		}
		wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver);
		driver.get(URL);
		
		//Login to App.
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp(USERNAME, PASSWORD);
		
		//Click on Organizations Link
		HomePage homePage=new HomePage(driver);
		homePage.organizationBtn();
	
		//Click on '+'(Create Organization
		CreateOrganizationPage createOrganizationPage=new CreateOrganizationPage(driver);
		createOrganizationPage.createOrganization(ORGNAME+rnum);
		
		Thread.sleep(2000);
								
		//Click on Contacts Module
		homePage.contactsBtn();
		
		//Create Contact with OrgName
		CreateContactWithOrgNamePage createContactWithOrgName=new CreateContactWithOrgNamePage(driver);
		createContactWithOrgName.createContactWithOrgName(driver, LASTNAME+rnum, ORGNAME+rnum);
		
//		//click on Create contact symbol(+)
//		CreateContactPage createContactPage=new CreateContactPage(driver);
//		createContactPage.createContactWithOrgName(driver, ORGNAME+rnum, LASTNAME);
//		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
//		
//		//Enter Mandatory Text
//		driver.findElement(By.name("lastname")).sendKeys(LASTNAME+rnum);
//		
//		//click on Organization symbol
//		
//		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
//		Set<String> child = driver.getWindowHandles();
//		for (String b:child) {
//			driver.switchTo().window(b);
//			
//		}
//		
//		//enter Organization name
//		driver.findElement(By.id("search_txt")).sendKeys(ORGNAME+rnum);
//		driver.findElement(By.name("search")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.id("1")).click();
//		
//					
//		//Switch to Parent Page
//		driver.switchTo().window(parent);
//		//Thread.sleep(2000);
//		
//		//Save the contact
//		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
//		
		String genLASTNAME = driver.findElement(By.id("mouseArea_Last Name")).getText();
		String genORGNAME = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		
		//verify Orgname and Contact Name
		if (genLASTNAME.contains(LASTNAME+rnum)) {
			if (genORGNAME.contains(ORGNAME+rnum)) {
				System.out.println("Contact Name "+LASTNAME+rnum+" created with Organization "+ORGNAME+rnum+".Test Pass");
				
			}
			}
		else {
			System.out.println("Test Fail!");
		}	
		
		//Logout of WebPage
		WebElement ele = driver.findElement(By.xpath("//td[@class='small']/table/tbody/tr/td[2]"));
		ele.click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		
	
	
	}
}