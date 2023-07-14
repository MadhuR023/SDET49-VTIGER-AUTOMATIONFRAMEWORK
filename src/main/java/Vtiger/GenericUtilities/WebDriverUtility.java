package Vtiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * This class consist of Generic methods to perform all WebDriver related Actions
 * @author Madhusudhan
 *
 */

public class WebDriverUtility extends BaseClass {
	/**
	 * This Method will maximize the Window
	 */
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();		
		}
	/**
	 * This Method will minimize the Window
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();		
	}
	
	/**
	 * This Method will is used to wait for page to load
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
	
	/**
	 * This Method will is used to wait for page to Element to be visible
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This Method will is used to wait for page to Element to be Clickable
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.elementToBeClickable(element));		
	}
	
	/**
	 * This Method will is used to dropdown with Index number
	 */
	public void handleDropDown(WebElement element, int index ) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This Method will is used to dropdown with Value
	 */
	public void handleDropDown(WebElement element, String Value) {
		Select s=new Select(element);
		s.selectByValue(Value);
	}
	
	/**
	 * This Method will is used to dropdown with VisibleText
	 */
	public void handleDropDown(String visibleValue,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(visibleValue);
	}
	
	/**
	 * This Method will is used to perform mousehover
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
		
	}
	
	
	/**
	 * This Method will is used to perform mousehover with Offset
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element, int x, int y) {
		Actions a=new Actions(driver);
		a.moveToElement(element, x, y).perform();
		
	}
	
	/**
	 * This Method will is used to perform Right Click Randomly
	 */
	public void rightClickAction(WebDriver driver) {
		Actions a=new Actions(driver);
		a.contextClick().perform();
		}
	
	/**
	 * This Method will is used to perform Right Click on Specific Element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * This Method will is used to perform Double click 
	 * 
	 * */
	public void doubleClickAction(WebDriver driver) {
		Actions a=new Actions(driver);
		a.doubleClick().perform();	
	}
	
	/**
	 * This Method will is used to perform DoubleClick on an Element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	/**
	 * This Method will is used to perform Drag and Drop rom Source to Target
	 */
	public void dragAndDrop(WebDriver driver, WebElement srcElement, WebElement tarElement) {
		Actions a=new Actions(driver);
		a.dragAndDrop(srcElement, tarElement).perform();
		
	}
	
	
	/**
	 * This Method will is used to perform Press and Release of Enter Key
	 * @throws AWTException
	 */	
	public void pressEnterKey() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This Method will is used to perform Press and Release of Enter Key
	 * @throws AWTException
	 */	
	public void SwitchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This Method will is used to perform Press and Release of Enter Key
	 * @throws AWTException
	 */	
	public void SwitchToFrame(WebDriver driver, String nameId) {
		driver.switchTo().frame(nameId);
	}
	
	/**
	 * This Method will is used to perform Press and Release of Enter Key
	 * @throws AWTException
	 */	
	public void SwitchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
	}
	
	public void scrollAction(WebDriver driver, WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		Point loc = element.getLocation();
		int y = loc.getY();
		js.executeScript("Window.ScrollBy(0, "+ y +")");
		}
	
	public String takeScreenShot(WebDriver driver, String screenshotname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+screenshotname+".png");
		Files.copy(src, dst);
		
		return dst.getAbsolutePath();
		
	}

	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for(String Indwincow:allWindows) {
			String currentWinTitle = driver.switchTo().window(Indwincow).getTitle();
			if (currentWinTitle.contains(partialWinTitle)) {
				break;
			}
		}
		
	}
	
}
