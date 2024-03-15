package com.QATest.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;


public class Test2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\QATest\\src\\main\\java\\com\\QATest\\chromedriver.exe");

        // Initialize the ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

		driver.get("https://klaaradmin-trials711.orangehrmlive.com/auth/seamlessLogin");

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000); // Sleep for 5 seconds
		driver.manage().window().maximize();

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("SyN6Ktl@O0");
		driver.findElement(By.xpath("//*[@id='frmLogin']/div[4]/button")).click();
		Thread.sleep(5000); 
		
		// Test 2: Create a Goal
        // Navigate to the Performance module
		//JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)");
		
		//WebElement performance = driver.findElement(By.xpath("//*[text()='Performance']"));
		//performance.click();
       // driver.findElement(By.id("menu_performance_viewPerformanceModule")).click();
        //driver.findElement(By.id("menu_performance_Goals")).click();
        
		//driver.findElement(By.id("menu-container")).click();

		//JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)");
		
		//2) Select Goals->My Goals
		//driver.findElement(By.xpath("//*[@id=\"top_level_menu_item_menu_item_237\"]/a")).click(); //*[@id="top_level_menu_item_menu_item_237"]/a/span
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='top-ribbon-menu']/div[3]/top-level-menu-item/div/a")));
*/
		//Thread.sleep(7000);

		//driver.findElement(By.linkText("More")).click();
		//driver.findElement(By.xpath("//*[@id='top-ribbon-menu']/div[3]/top-level-menu-item/div/sub-menu-container/div/div[2]/a/i")).click();
		//driver.findElement(By.linkText("Goal List")).click();

		//3)Click on create goal and verify
		//driver.findElement(By.xpath("//*[@id='goalListContainer']/div/div/list/div/div[1]/button/span")).click();
		//String expectedoutput=driver.findElement(By.xpath("//*[@id='addGoalContainer']/div/div[1]/span/h4")).getText();		//driver.close();
		//String ActualOutput="Add Goal";
		//if(ActualOutput.equals(expectedoutput))
		//{
		//	System.out.println("You have successfully landed on the page of to create a goal");
		//}

		//4)Fill data on Create Goal page
		//driver.findElement(By.id("name_value")).sendKeys("Tset1");
		//js.executeScript("window.scrollBy(0,300)");
		//WebElement sendate = driver.findElement(By.xpath("//*[@id='addGoalContainer']/div/div[2]/form/div/div/oxd-decorator[2]/div/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div/button/i"));
		//sendate.sendKeys("12-january-2024");
		//driver.findElement(By.id("selectedEmployee_value")).sendKeys("Tester");

		//5) In editor insert an image

		

		//6) Set priority to be high and height to be 20
		//Select opt=new Select(driver.findElement(By.cssSelector("filter-option")));
		//opt.selectByValue("High");
		//driver.findElement(By.xpath("//*[@id='spinnerInputweight']")).clear();
		//driver.findElement(By.xpath("//*[@id='spinnerInputweight']")).sendKeys("20");

		//7) Save goal and verify goal details
		//driver.findElement(By.xpath("//*[@id=\"addGoalContainer\"]/div/div[2]/form/div/div/oxd-decorator[4]/div/div[2]/button")).click();

	}
}