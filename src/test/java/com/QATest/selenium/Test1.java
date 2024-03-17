package com.QATest.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test1 {
	
	
	WebDriver driver;

	@BeforeTest
	public void initDriver() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\QATest\\src\\main\\java\\com\\QATest\\chromedriver.exe");
		
		// Initialize the ChromeDriver instance
        driver = new ChromeDriver();
        
        // Maximize the browser window
        driver.manage().window().maximize();
        //1)Visit the website
        driver.get("https://klaaradmin-trials711.orangehrmlive.com/auth/seamlessLogin");
        Thread.sleep(5000);
        driver.manage().window().maximize();

	}
	
	@Test
    public void Login() throws InterruptedException {
    	
		//fill username and password fields
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        WebElement loginButton = driver.findElement(By.xpath("//*[text()='Login']"));
        
        usernameField.sendKeys("Admin");
        passwordField.sendKeys("SyN6Ktl@O0");
        loginButton.click();
        
        //2)Navigate to the Employee Management Module
        driver.findElement(By.id("menu_item_128")).click();
		Thread.sleep(5000); // Sleep for 5 seconds
		
		//3)Click on Add Employee button 
		driver.findElement(By.xpath("//*[@id=\"addEmployeeButton\"]/i")).click();
		Thread.sleep(5000); // Sleep for 5 seconds
		
		//4)Fill in required fields
        WebElement firstNameField = driver.findElement(By.id("first-name-box"));
        WebElement middleNameField = driver.findElement(By.id("middle-name-box"));
        WebElement lastNameField = driver.findElement(By.id("last-name-box"));
        firstNameField.sendKeys("JohnD");
        middleNameField.sendKeys("clark");
        lastNameField.sendKeys("Doe");
        Thread.sleep(5000); // Sleep for 5 seconds
        
        //4)Disable Auto Generate Employee ID
        WebElement checkbox = driver.findElement(By.id("autoGenerateEmployeeId"));
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].click();", checkbox);
        
        //5)Add an employee ID
        WebElement employeeIdField = driver.findElement(By.id("employeeId"));
        employeeIdField.sendKeys("12345");
        
        //6) Change the joined date and select a new date that is 5 days ahead of today's date.
        // Locate and click on the joined date input field
        WebElement joinedDateInput = driver.findElement(By.id("joinedDate"));
        joinedDateInput.click();
        
        // Calculate the new date that is 5 days ahead of today's date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        Date newDate = calendar.getTime();
        
        // Convert the new date to a string format compatible with the date picker
        String newDateString = newDate.toString(); // You may need to format the date according to the date picker's requirements
        // Execute JavaScript to set the value of the joined date input field
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].setAttribute('value', arguments[1])", joinedDateInput, newDateString);
        System.out.println("Date selected :" + newDateString);
        Thread.sleep(5000);
        
       //7)Choose the location as the “India Office”.
        WebElement locationDropdown = driver.findElement(By.xpath("//*[@id=\"modal-holder\"]/div/div/div/div[2]/form/oxd-decorator/div/div[2]/div/div[3]/div/div[3]/div/div[1]/button/div/div/div"));
        locationDropdown.click();
        WebElement indiaOfficeOption = driver.findElement(By.id("bs-select-1-10"));
        indiaOfficeOption.click();
        Thread.sleep(5000);
        
       //8)Enable "Create Login Details" and add a username and password. 
       //Set the Admin Role to "Regional HR Admin..
        WebElement createLoginCheckbox = driver.findElement(By.xpath("//*[@id=\"modal-holder\"]/div/div/div/div[2]/form/oxd-decorator/div/div[2]/div/div[5]/div/div/span/div[2]"));
        createLoginCheckbox.click();
        
        String username = "JohnD"; // Replace with dynamic data if needed
        WebElement usernameField1 = driver.findElement(By.id("username"));
        usernameField1.sendKeys(username);
        
        String password = "SyN6Ktl@O0"; // Replace with dynamic data if needed
        WebElement passwordField1 = driver.findElement(By.id("password"));
        passwordField1.sendKeys(password);
        
        WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));
        confirmPasswordField.sendKeys(password);
        Thread.sleep(5000);
        
        //WebElement adminRoleDropdown = driver.findElement(By.xpath("//*[@id=\"modal-holder\"]/div/div/div/div[2]/form/oxd-decorator/div/div[2]/div/div[11]/div/div[3]/div/div[1]/button/div/div/div"));
       // adminRoleDropdown.click();
       // Thread.sleep(5000);
        //WebElement adminrole = driver.findElement(By.xpath("//*[@id=\"bs-select-16-4\"]/span"));
       // adminrole.click();
        
        
        
       
    }
	
	@AfterTest
	public void tearDown() throws InterruptedException {
	//Thread.sleep(5000);
	//driver.close();
	//driver.quit();
	}
}