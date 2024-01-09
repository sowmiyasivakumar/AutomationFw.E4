package generalUtilities;

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
/**
 * this class consist of reusable methods related to selenium file
 * @author Sowmiya
 */
public class SeleniumUtility 
{
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * this method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * this method will launch the browser in full screen mode
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	
	/**
	 * this method will wait for 10seconds for all the webelement to be loaded
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * this method will wait for 10 seconds for particular web element to become visible
	 * @param driver
	 * @param element
	 */
public void waitforElementToBeVisible(WebDriver driver,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * this method will wait for 10 seconds for particular web element to become click
 * @param driver
 * @param element
 */
public void waitforElementToBeClickable(WebDriver driver,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * this method will handle dropdown by index
 * @param element
 * @param index
 */
public void handleDropDown(WebElement element,int index)
{
	Select sel=new Select(element);
	sel.selectByIndex(index);
	
}
/**
 * this method will handle dropdown by value
 * @param element
 * @param value
 */
public void handleDropDown(WebElement element,String value )
{
	Select sel=new Select(element);
	sel.selectByValue(value);
	
}
/**
 * this method will handle dropdown by visibleText
 * @param element
 * @param text
 */
public void handleDropDown(String text,WebElement element)
{
	Select sel=new Select(element);
	sel.selectByVisibleText(text);
	
}
/**
 * this method will perform mouse hovering action on web element
 * @param driver
 * @param element
 */
public void mouseOverAction(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}
/**
 * this method will perform right click on web element
 * @param driver
 * @param element
 */
public void rightClickAction(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
}
/**
 * this method will perform double click on web element
 * @param driver
 * @param element
 */
public void doubleClickAction(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
}
/**
 * this method will perform drag and drop actions
 * @param driver
 * @param srcElement
 * @param desElement
 */
public void dragAndDropAction(WebDriver driver,WebElement srcElement,WebElement desElement)
{
	Actions act=new Actions(driver);
	act.dragAndDrop(srcElement, desElement).perform();
}
/**
 * this method will scroll down for 500 units
 * @param driver
 */
public void scrollDownAction(WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("Window.scrollBy(0,500)");
}
/**
 * this method will scroll up for 500 units
 * @param driver
 */
public void scrollUpAction(WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("Window.scrollBy(0,-500)");
}
/**
 * this method will accept alert popup
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/**
 * this method will cancel alert popup
 * @param driver
 */
public void cancelAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * this method will capture the text in alert popup and return it to caller
 * @param driver
 * @return
 */
public String getAlertText(WebDriver driver)
{
	return driver.switchTo().alert().getText();
}
/**
 * this method will handle frame by frame index
 * @param driver
 * @param frameIndex
 */
public void handleFrame(WebDriver driver,int frameIndex)
{
	driver.switchTo().frame(frameIndex);
}
/**
 * this method will handle frame by frame name or Id
 * @param driver
 * @param frameNameId
 */
public void handleFrame(WebDriver driver,String frameNameId)
{
	driver.switchTo().frame(frameNameId);
}
/**
 * this method will handle frame by frame element
 * @param driver
 * @param frameElement
 */
public void handleFrame(WebDriver driver,WebElement frameElement)
{
	driver.switchTo().frame(frameElement);
}
/**
 * this method will capture the screenshot and return the absolute path
 * @param driver
 * @param screenshotName
 * @return AbsolutePath
 * @throws IOException
 */
public String captureScreenShot(WebDriver driver,String screenshotName) throws IOException 
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest = new File(".\\ScreenShots\\"+screenshotName+".png");
	Files.copy(src, dest);
	return dest.getAbsolutePath();//it will return the absolute path of file
	//attaching this screenshot to extend reports
}
/**
 * this method will switch the control to required window based on the title
 * @param driver
 * @param ExpectedpartialTitle
 */

public void handleWindow(WebDriver driver,String ExpectedpartialTitle)
{
	Set<String> allwinid = driver.getWindowHandles();//capture all window id
	//navigate through each window id
	for(String winid:allwinid)
	{
		//switch to each window id and capture the title
		String actualTitle = driver.switchTo().window(winid).getTitle();
		//compare the window titles
		if(actualTitle.contains(ExpectedpartialTitle))
		{
			break;
		}
	}
	
}

}
