package dropdownexample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownExample {
	WebDriver driver;
	WebElement dropdownelement;
	
	@BeforeMethod
	public void init()
	{
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/samplepagetest/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void cleanup()
	{
		driver.quit();
	}
	
	@Test
	public void test1() throws InterruptedException
	{		
		dropdownelement = driver.findElement(By.xpath("//select[@id = 'g2599-experienceinyears']"));
		
		Select dropdownvalue = new Select(dropdownelement);
		dropdownvalue.selectByIndex(5);
	}
	
	@Test
	public void test2()
	{
		dropdownelement = driver.findElement(By.xpath("//select[@id = 'g2599-experienceinyears']"));
		dropdownelement.click();
		
		Actions action = new Actions(driver);
		WebElement option = driver.findElement(By.xpath("//option[@value= '5-7']"));
		action.moveToElement(option).click().perform();
	}
	
	
}
