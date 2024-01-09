package Practice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalenderPopup {

	public static void main(String[] args) throws Throwable
	{
		//launch the browser
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//navigate to app
		driver.get("https://www.makemytrip.com/");	
		//WebElement close = driver.findElement(By.cssSelector("#webklipper-publisher-widget-container-notification-close-div"));
		Actions act=new Actions(driver);
	     act.moveByOffset(10,10).click().perform();
	     //click on departure
		driver.findElement(By.xpath("//span[text()=\"Departure\"]")).click();
		
		//scenario 1:book a flight for the date in current DOM structure
		
		//driver.findElement(By.xpath("//div[@aria-label=\"Thu Jan 25 2024\"]")).click();//direct
		//driver.findElement(By.xpath("//div[text()=\"January 2024\"]//ancestor::div[@class=\"DayPicker-Month\"]//descendant::p[text()=\"26\"]")).click();//dynamic
		
		//scenario 2:book a d flight for the future date
		for(;;)
		{
			try
			{
				driver.findElement(By.xpath("//div[@aria-label=\"Thu Jun 20 2024\"]")).click();
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[@aria-label=\"Next Month\"]")).click();
				//Thread.sleep(1000);
			}
		}
		
		
	}

}
