package com.QATest.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class Test2Copy {
	
	WebDriver driver;

	@BeforeTest
	public void initDriver() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\QATest\\src\\main\\java\\com\\QATest\\chromedriver.exe");
		
		// Initialize the ChromeDriver instance
        driver = new ChromeDriver();
        
        // Maximize the browser window
        driver.manage().window().maximize();
        driver.get("https://klaaradmin-trials711.orangehrmlive.com/auth/seamlessLogin");
        Thread.sleep(5000);
        driver.manage().window().maximize();

	}
	@Test
	public void Login() throws InterruptedException {
		
		//1)Navigate to Performance Module
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("SyN6Ktl@O0");
		driver.findElement(By.xpath("//*[@id='frmLogin']/div[4]/button")).click();
		
		driver.findElement(By.id("menu-container")).click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		//2) Select Goals->My Goals
		driver.findElement(By.xpath("//*[@id='menu_item_241']/span")).click();
		driver.findElement(By.id("top_level_menu_item_menu_item_237")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id=\"top_level_menu_item_menu_item_237\"]/sub-menu-container/div/div[2]/a")).click();
		Thread.sleep(5000);
		
		//3)Click on create goal and verify
		driver.findElement(By.xpath("//*[@id='goalListContainer']/div/div/list/div/div[1]/button/span")).click();
		String expectedoutput=driver.findElement(By.xpath("//*[@id='addGoalContainer']/div/div[1]/span/h4")).getText();		
		String ActualOutput="Add Goal";
		if(ActualOutput.equals(expectedoutput))
		{
			System.out.println("You have successfully landed on the page of to create a goal");
		}
		Thread.sleep(5000);
		
		//4)Fill data on Create Goal page
		WebElement goalNameField = driver.findElement(By.id("name_value"));
		goalNameField.sendKeys("Test Goal");
		String goalName = goalNameField.getAttribute("value");
		System.out.println("Goal : "+ goalName);
		Thread.sleep(5000);
		
		//5) In editor insert an image
		//Actions class method to drag and drop		
		Actions builder = new Actions(driver);
		
		//6) Set priority to be high and height to be 20
		Select priority = new Select(driver.findElement(By.id("goalPriority")));
		priority.selectByVisibleText("High");
		String priorityt = priority.getFirstSelectedOption().getText();
		System.out.println("Priority : " +priorityt);
		
		driver.findElement(By.xpath("//*[@id='spinnerInputweight']")).clear();
		WebElement weightSelect = driver.findElement(By.xpath("//*[@id='spinnerInputweight']"));
		weightSelect.sendKeys("10");
		String weight = weightSelect.getAttribute("value");
		System.out.println("Weight : " +weight);
		
		
		js.executeScript("window.scrollBy(0,300)");
		WebElement sendate = driver.findElement(By.xpath("//*[@id=\"addGoalContainer\"]/div/div[2]/form/div/div/oxd-decorator[2]/div/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div/button/i"));
		sendate.click();
		WebElement date_element = driver.findElement(By.xpath("//div[@class='picker__day picker__day--infocus'][text()='22']"));
		date_element.click();

		//7) Save goal and verify goal details
		driver.findElement(By.xpath("//*[@id=\"addGoalContainer\"]/div/div[2]/form/div/div/oxd-decorator[4]/div/div[2]/button")).click();
		
		// Expected values
		String expectedGoalName = "Test Goal";
		String expectedPriority = "High";
		String expectedWeight = "10";

		// Verifying the goal details
		if (goalName.equals(expectedGoalName) && 
		    priorityt.equals(expectedPriority) && 
		    weight.equals(expectedWeight)) {
		    System.out.println("Goal details match the expected values.");
		} else {
		    System.out.println("Goal details do not match the expected values.");
		}

	}
	@AfterTest
	public void tearDown() throws InterruptedException {
	//Thread.sleep(5000);
	//driver.close();
	//driver.quit();
	}

}