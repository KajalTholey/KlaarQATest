package com.QATest.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
    	
    	//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\QATest\\src\\main\\java\\com\\QATest\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver(options);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\QATest\\src\\main\\java\\com\\QATest\\chromedriver.exe");

        // Initialize the ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to Amazon website
        driver.get(" https://klaaradmin-trials711.orangehrmlive.com/client/#/dashboard ");
        
        // Find and fill in username and password fields
        WebElement usernameField = driver.findElement(By.id("txtUsername"));
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        WebElement loginButton = driver.findElement(By.xpath("//*[text()='Login']"));
        
        usernameField.sendKeys("Admin");
        passwordField.sendKeys("SyN6Ktl@O0");
        loginButton.click();
        
     // Test 1: Add an Employee
        // Navigate to the Employee Management Module
        driver.findElement(By.id("menu_item_128")).click();
		Thread.sleep(5000); // Sleep for 5 seconds
		driver.findElement(By.xpath("//*[@id=\"addEmployeeButton\"]/i")).click();
		
		Thread.sleep(5000); // Sleep for 5 seconds
		// Fill in required fields
        WebElement firstNameField = driver.findElement(By.id("first-name-box"));
        WebElement middleNameField = driver.findElement(By.id("middle-name-box"));
        WebElement lastNameField = driver.findElement(By.id("last-name-box"));
        firstNameField.sendKeys("John");
        middleNameField.sendKeys("clark");
        lastNameField.sendKeys("Doe");
        Thread.sleep(5000); // Sleep for 5 seconds
        
     // Disable Auto Generate Employee ID
        WebElement checkbox = driver.findElement(By.id("autoGenerateEmployeeId"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", checkbox);
        
     // Add employee ID
        WebElement employeeIdField = driver.findElement(By.id("employeeId"));
        employeeIdField.sendKeys("12345");
       
    }
}