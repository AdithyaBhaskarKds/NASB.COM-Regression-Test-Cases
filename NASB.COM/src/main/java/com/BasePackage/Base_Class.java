package com.BasePackage;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utility.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	public static RemoteWebDriver driver = null;
//	private static By L_username = By.xpath("//input[@aria-label='User ID']");
	public static String Pagetitle;

	public static Properties configloader() throws IOException {
		FileInputStream File = new FileInputStream(".\\src\\test\\resources\\config.properties");
		Properties properties = new Properties();
		properties.load(File);
		return properties;		
	}

	public  void setup() throws IOException, InterruptedException {

		String Browser = configloader().getProperty("Browser");
		String Url = configloader().getProperty("URL");
		

		switch (Browser.toUpperCase()) {

		case "CHROME":

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);			
			break;

		case "FIREFOX":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
			break;

		default:
			System.err.println("The Driver is not defined");
		}

		driver.manage().window().maximize();
		Log.info("Driver has initialized successful for "+Browser+"browser");
		driver.get(Url);
		Thread.sleep(2000);
		


	}


	public static  void input(By element, String Value) throws InterruptedException {


		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.presenceOfElementLocated(element)).sendKeys(Value);


	}

	public static  void click(By element) throws InterruptedException {

		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		Thread.sleep(2000);

	}

	public static void explicitWait(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));

	}



}
