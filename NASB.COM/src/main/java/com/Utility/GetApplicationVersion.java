package com.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BasePackage.Base_Class;

public class GetApplicationVersion extends Base_Class{
	public String getVersion() throws InterruptedException
	{
		WebElement searchelement = driver.findElement(By.xpath("(//div[contains(@id,'copyrightcontainer-')])[1]"));
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].scrollIntoView();", searchelement);
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@id,'copyrightcontainer-')])[2]/p[2]/span")));
		Thread.sleep(1000);
		String ver=driver.findElement(By.xpath("(//div[contains(@id,'copyrightcontainer-')])[2]/p[2]/span")).getText();
		return ver;
	}

}
