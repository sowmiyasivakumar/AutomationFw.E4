package Practice;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalenderPopupCurrentDate {

	public static void main(String[] args) {
		//scenario 3:book a flight for the current date (system date)
				Date d=new Date();
				String dateNow = d.toString();
				System.out.println(dateNow);
				String[] dArr = d.toString().split(" ");
				String currentDate = dArr[0]+" "+dArr[1]+" "+dArr[2]+" "+dArr[5];
                 System.out.println(currentDate);
                 
               //launch the browser
         		WebDriver driver=new EdgeDriver();
         		driver.manage().window().maximize();
         		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         		
         		//navigate to app
         		driver.get("https://www.makemytrip.com/");	
         		//handle popup
         		Actions act=new Actions(driver);
       	     act.moveByOffset(10,10).click().perform();
       	     //click on departure
       		driver.findElement(By.xpath("//span[text()=\"Departure\"]")).click();
       		
       		//navigate to current date in calender
       		driver.findElement(By.xpath("//div[@aria-label='"+currentDate+"']")).click();
       		                             //div[@aria-label='sat jun 05 2023']
	
	}

}
