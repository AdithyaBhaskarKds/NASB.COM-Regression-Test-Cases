package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utility.GetTodayAndAfterOneYearOfTodayDate;
import com.Utility.Log;
import com.Utility.SuccessScreenShotCapture;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginNASB {
	public void checkMortgageRateCalculator() throws IOException, InterruptedException
	{
		ExtentTestManager.getTest().log(Status.INFO, "TC01 Verify the Mortgage Rate Calculator is working correctly for the website nasb.com test case summary");
		Log.info("Verify the Mortgage Rate Calculator is working correctly for the website nasb.com test case summary");
		GetTodayAndAfterOneYearOfTodayDate gt=new GetTodayAndAfterOneYearOfTodayDate();
		String tcName="Check Mortgaeg Rate";
		SuccessScreenShotCapture ss=new SuccessScreenShotCapture();
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		Log.info("Driver has initialized successful for chrome browser");
		driver.get("nasb.com");
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='onetrust-accept-btn-handler']")));
		Thread.sleep(1000);
		element.click();
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 40);
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Here')]"))) != null)
		{
			System.out.println("Webel Found---------------------------------------------------------");
			
		}
		else
		{
			System.out.println("Webel Not Found---------------------------------------------------------------");
		}
		
		wait = new WebDriverWait(driver, 40);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@data-original-title='Rates'])[1]")));
		Thread.sleep(1000);
		element.click();
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Competitive rates for the product you need.']")));
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Mortgage Rates'])[2]")));
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href=\"/lending/resources/mortgage-rates\"])[3]")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@href=\"/lending/resources/mortgage-rates\"])[3]")).click();
		
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Find Today')]")));
		Thread.sleep(1000);
		WebElement searchelement = driver.findElement(By.xpath("//h2[contains(text(),'Find Today')]"));
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView();", searchelement);
		Thread.sleep(4000);
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='propertyvalue']")));
		
		String pValue=driver.findElement(By.xpath("//input[@name='propertyvalue']")).getAttribute("value");
		String doPay=driver.findElement(By.xpath("//input[@name='downPayment']")).getAttribute("value");
		String credRating=driver.findElement(By.xpath("//select[@id='creditRating']")).getAttribute("value");
		String state=driver.findElement(By.xpath("//select[@id='state']")).getAttribute("value");
		String country=driver.findElement(By.xpath("//select[@id='OBcounty']")).getAttribute("value");
		String today=gt.today();
		ExtentTestManager.getTest().log(Status.INFO, "Today's "+today+" Mortgage Interest Rates are below:");
		
		Log.info("Today's "+today+" Mortgage Interest Rates are below:");
		ExtentTestManager.getTest().log(Status.INFO, "Property Value: "+pValue);
		Log.info("Property Value: "+pValue);
		ExtentTestManager.getTest().log(Status.INFO, "Down Payment: "+doPay);
		Log.info("Down Payment: "+doPay);
		ExtentTestManager.getTest().log(Status.INFO, "Credit Rating: "+credRating);
		Log.info("Credit Rating: "+credRating);
		ExtentTestManager.getTest().log(Status.INFO, "State: "+state);
		Log.info("State: "+state);
		ExtentTestManager.getTest().log(Status.INFO, "Country: "+country);
		Log.info("Country: "+country);
		ss.capture(tcName, "Mortage Interest Rate Calculator");
		searchelement = driver.findElement(By.xpath("//a[text()='Get Rates']"));
    	js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView();", searchelement);
		Thread.sleep(1000);
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//strong[@class='value-amortization product-name'])[6]")));
		
		String product=driver.findElement(By.xpath("(//strong[@class='value-amortization product-name'])[6]")).getText();
		String rate=driver.findElement(By.xpath("(//span[@class='value-rate-fees'])[6]")).getText();
		String apr=driver.findElement(By.xpath("(//span[@class='value-apr'])[6]")).getText();
		String payment=driver.findElement(By.xpath("(//span[@class='value-monthly-payment'])[6]")).getText();
		String monthlyPMI=driver.findElement(By.xpath("(//span[@class='value-monthly-premium'])[6]")).getText();
		String fees=driver.findElement(By.xpath("(//span[@class='value-total-fees'])[6]")).getText();
//		System.out.println("For the product "+product);
//		System.out.println("Rate is: "+rate+"\t"+"APR is: "+apr+"\t"+"Payment is: "+payment+"\t"+"Monthly PMI is: "+monthlyPMI+"\t"+"Fees is: "+fees);
		ExtentTestManager.getTest().log(Status.INFO, "As Of Today "+today+" For the product "+product);
		ExtentTestManager.getTest().log(Status.INFO, "Rate is: "+rate);
		ExtentTestManager.getTest().log(Status.INFO, "APR is: "+apr);
		ExtentTestManager.getTest().log(Status.INFO, "Payment is: "+payment);
		ExtentTestManager.getTest().log(Status.INFO, "Monthly PMI is: "+monthlyPMI);
		ExtentTestManager.getTest().log(Status.INFO, "Fees is: "+fees);
		ExtentTestManager.getTest().log(Status.INFO, "--------------------------------------------------------------------------------------------------------------");
		Log.info("As Of Today "+today+" For the product "+product);
		Log.info("Rate is: "+rate);
		Log.info("APR is: "+apr);
		Log.info("Payment is: "+payment);
		Log.info("Monthly PMI is: "+monthlyPMI);
		Log.info("Fees is: "+fees);
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		product=driver.findElement(By.xpath("(//strong[@class='value-amortization product-name'])[7]")).getText();
		rate=driver.findElement(By.xpath("(//span[@class='value-rate-fees'])[7]")).getText();
		apr=driver.findElement(By.xpath("(//span[@class='value-apr'])[7]")).getText();
		payment=driver.findElement(By.xpath("(//span[@class='value-monthly-payment'])[7]")).getText();
		monthlyPMI=driver.findElement(By.xpath("(//span[@class='value-monthly-premium'])[7]")).getText();
		fees=driver.findElement(By.xpath("(//span[@class='value-total-fees'])[7]")).getText();
//		System.out.println("For the product "+product);
//		System.out.println("Rate is: "+rate+"\t"+"APR is: "+apr+"\t"+"Payment is: "+payment+"\t"+"Monthly PMI is: "+monthlyPMI+"\t"+"Fees is: "+fees);
		ExtentTestManager.getTest().log(Status.INFO, "As Of Today "+today+" For the product "+product);
		ExtentTestManager.getTest().log(Status.INFO, "Rate is: "+rate);
		ExtentTestManager.getTest().log(Status.INFO, "APR is: "+apr);
		ExtentTestManager.getTest().log(Status.INFO, "Payment is: "+payment);
		ExtentTestManager.getTest().log(Status.INFO, "Monthly PMI is: "+monthlyPMI);
		ExtentTestManager.getTest().log(Status.INFO, "Fees is: "+fees);
		ExtentTestManager.getTest().log(Status.INFO, "--------------------------------------------------------------------------------------------------------------");
		Log.info("As Of Today "+today+" For the product "+product);
		Log.info("Rate is: "+rate);
		Log.info("APR is: "+apr);
		Log.info("Payment is: "+payment);
		Log.info("Monthly PMI is: "+monthlyPMI);
		Log.info("Fees is: "+fees);
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		product=driver.findElement(By.xpath("(//strong[@class='value-amortization product-name'])[8]")).getText();
		rate=driver.findElement(By.xpath("(//span[@class='value-rate-fees'])[8]")).getText();
		apr=driver.findElement(By.xpath("(//span[@class='value-apr'])[8]")).getText();
		payment=driver.findElement(By.xpath("(//span[@class='value-monthly-payment'])[8]")).getText();
		monthlyPMI=driver.findElement(By.xpath("(//span[@class='value-monthly-premium'])[8]")).getText();
		fees=driver.findElement(By.xpath("(//span[@class='value-total-fees'])[8]")).getText();
//		System.out.println("For the product "+product);
//		System.out.println("Rate is: "+rate+"\t"+"APR is: "+apr+"\t"+"Payment is: "+payment+"\t"+"Monthly PMI is: "+monthlyPMI+"\t"+"Fees is: "+fees);
		ExtentTestManager.getTest().log(Status.INFO, "As Of Today "+today+" For the product "+product);
		ExtentTestManager.getTest().log(Status.INFO, "Rate is: "+rate);
		ExtentTestManager.getTest().log(Status.INFO, "APR is: "+apr);
		ExtentTestManager.getTest().log(Status.INFO, "Payment is: "+payment);
		ExtentTestManager.getTest().log(Status.INFO, "Monthly PMI is: "+monthlyPMI);
		ExtentTestManager.getTest().log(Status.INFO, "Fees is: "+fees);
		ExtentTestManager.getTest().log(Status.INFO, "--------------------------------------------------------------------------------------------------------------");
		Log.info("As Of Today "+today+" For the product "+product);
		Log.info("Rate is: "+rate);
		Log.info("APR is: "+apr);
		Log.info("Payment is: "+payment);
		Log.info("Monthly PMI is: "+monthlyPMI);
		Log.info("Fees is: "+fees);
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		product=driver.findElement(By.xpath("(//strong[@class='value-amortization product-name'])[9]")).getText();
		rate=driver.findElement(By.xpath("(//span[@class='value-rate-fees'])[9]")).getText();
		apr=driver.findElement(By.xpath("(//span[@class='value-apr'])[9]")).getText();
		payment=driver.findElement(By.xpath("(//span[@class='value-monthly-payment'])[9]")).getText();
		monthlyPMI=driver.findElement(By.xpath("(//span[@class='value-monthly-premium'])[9]")).getText();
		fees=driver.findElement(By.xpath("(//span[@class='value-total-fees'])[9]")).getText();
//		System.out.println("For the product "+product);
//		System.out.println("Rate is: "+rate+"\t"+"APR is: "+apr+"\t"+"Payment is: "+payment+"\t"+"Monthly PMI is: "+monthlyPMI+"\t"+"Fees is: "+fees);
		ExtentTestManager.getTest().log(Status.INFO, "As Of Today "+today+" For the product "+product);
		ExtentTestManager.getTest().log(Status.INFO, "Rate is: "+rate);
		ExtentTestManager.getTest().log(Status.INFO, "APR is: "+apr);
		ExtentTestManager.getTest().log(Status.INFO, "Payment is: "+payment);
		ExtentTestManager.getTest().log(Status.INFO, "Monthly PMI is: "+monthlyPMI);
		ExtentTestManager.getTest().log(Status.INFO, "Fees is: "+fees);
		ExtentTestManager.getTest().log(Status.INFO, "--------------------------------------------------------------------------------------------------------------");
		Log.info("As Of Today "+today+" For the product "+product);
		Log.info("Rate is: "+rate);
		Log.info("APR is: "+apr);
		Log.info("Payment is: "+payment);
		Log.info("Monthly PMI is: "+monthlyPMI);
		Log.info("Fees is: "+fees);
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		ss.capture(tcName, "Rates");
		ExtentTestManager.getTest().log(Status.PASS, "Today's "+today+" Mortgage interest rates are displyed successfully");
		Log.info("Today's "+today+" Mortgage interest rates are displyed successfully");
		driver.quit();
		ExtentTestManager.getTest().log(Status.INFO, "***************************** END OF ABOVE TEST CASE RESULT *****************************");
		Log.info("***************************** END OF ABOVE TEST CASE RESULT *****************************");
		
	}
}
