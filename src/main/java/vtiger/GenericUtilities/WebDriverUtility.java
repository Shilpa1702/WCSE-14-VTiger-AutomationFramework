package vtiger.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	
	/**
	 * This class contains generic method to perform all web driver related actions
	 * @author shilpa
	 */

	public void maximizeWindow(WebDriver driver)
	{
		/**
		 * This method will maximize the window when it is called
		 * @author shilpa
		 */
		driver.manage().window().maximize();
	}
	public void minimizeWindow(WebDriver driver)
	{
		/**
		 * This method will mininmize whenever it is called
		 * @author shilpa
		 */
		driver.manage().window().minimize();
	}
	public void waitForPageLoad(WebDriver driver)
	{
		/**
		 * This method will wait for entire page to load for 20 sec
		 * @author shilpa
		 */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
public void WaitForElementToBeVisible(WebDriver driver,WebElement element)
{
	/**
	 * This method is used to wait for an element to be visible
	 * @author shilpa
	 * 
	 */
	
	WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
}
public void WaitForElementToBeClickable(WebDriver driver,WebElement element)
{
	/**
	 * This method is used to wait for an element to be clickable
	 * @author shilpa
	 * 
	 */
	
	WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	
}
	
public void customeWaitForSeconds(WebElement element) throws InterruptedException	
{
	int count=0;
	while(count<10)
	{
		
		try
		{
			element.click();
			break;
			
		}
		catch(Exception e)
		{
			Thread.sleep(1000);
			count++;
		}
	}
}
	

public void handleDropDown(WebElement element, int index)
{
	/**
	 * This method will handle drop down based on index value
	 */
	Select sel =new Select (element);
	sel.selectByIndex(index);

}		
public void handleDropDown(WebElement element, String value)
{
	/**
	 * This method will handle drop down based on value
	 */
	Select sel =new Select (element);
	sel.selectByValue(value);

}
public void handleDropDown(String visibleText,WebElement element)
{
	/**
	 * This method will handle drop down based on visible Text
	 */
	Select sel =new Select (element);
	sel.selectByVisibleText(visibleText);

}
public void mouseHoverAction(WebDriver driver, WebElement element)
{
	/**
	 * This method will perform mousehover action
	 * 
	 */
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}
public void mouseHoverAction(WebDriver driver, WebElement element,int x,int y)
{
	/**
	 * This method will perform mousehover action based on offset
	 * 
	 */
	Actions act=new Actions(driver);
	act.moveToElement(element, x, y).perform();
	
}
public void rightClickAction(WebDriver driver)
{
	/**
	 * This method will perform right click action randomly on web page
	 * 
	 */
	Actions act=new Actions(driver);
	act.contextClick().perform();
	
}
public void rightClickAction(WebDriver driver,WebElement element)
{
	/**
	 * This method will perform right click action on perticular webelement
	 * 
	 */
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
	
}
public void doubleClickAction(WebDriver driver)
{
	/**
	 * This method will perform double click action any wher on web page
	 * 
	 */
	Actions act=new Actions(driver);
	act.doubleClick().perform();
	
}
public void doubleClickAction(WebDriver driver,WebElement element)
{
	/**
	 * This method will perform double click action on a perticular web element
	 * 
	 */
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
	
}
public void dragAndDropAction(WebDriver driver,WebElement srcElement,WebElement tagElement)
{
	/**
	 * This method will perform dragand drop from source element to target element
	 * 
	 */
	Actions act=new Actions(driver);
	act.dragAndDrop(srcElement,srcElement).perform();
	
}
public void pressEntryKey() throws AWTException
{
	/**
	 * This method will press and release the entry key
	 */
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	
}
public void switchToFrame(WebDriver driver, int index)
{
	/**
	 * This method will switch the frame based on index
	 */
driver.switchTo().frame(index);
}
public void switchToFrame(WebDriver driver, String nameOrId)
{
	/**
	 * This method will switch the frame based on nameorid
	 */
driver.switchTo().frame(nameOrId);
}
public void switchToFrame(WebDriver driver, WebElement element)
{
	/**
	 * This method will switch the frame based on element
	 */
driver.switchTo().frame(element);
}
public void switchToDefaultFrame(WebDriver driver)
{
	/**
	 * This method will switch to default frame 
	 */
driver.switchTo().defaultContent();
}
	
public void scrollAction(WebDriver driver)
{
	/**
	 * This method will scroll down for 500 units
	 * @author shilpa
	 */
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)");
}

public void scrollAction(WebDriver driver, WebElement element)
{
	/**
	 * This method will scroll down untill a perticular
	 * @author shilpa
	 */
	JavascriptExecutor js=(JavascriptExecutor)driver;
	int y=element.getLocation().getY();
	js.executeScript("window.scrollBy(0,"+y+")",element);
	
}
public String taketheScreenShot(WebDriver driver,String screenShotName) throws IOException
{
	/**
	 * This methos will take screen shot and save it in the Screen shot folder
	 * @author shilpa
	 */
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dst=new File(".\\ScreenShots\\+screenShotName+.png");
	Files.copy(src, dst);
	return dst.getAbsolutePath();//for extend report
}
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		Set<String> allWindow = driver.getWindowHandles();
		for(String indWindow:allWindow)
		{
			String currentWinTitle=driver.switchTo().window(indWindow).getTitle();
			if(currentWinTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
			 
}
	
	

	
	
	
	








			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	

	
	





