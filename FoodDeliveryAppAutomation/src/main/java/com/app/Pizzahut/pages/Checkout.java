package com.app.Pizzahut.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class Checkout {
	
	WebDriver driver;

	
	public Checkout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	
	public void clickApplyGiftCard() {
		
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.cssSelector(".sc-fzqMdD.eohbfP"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector(".sc-fzqMdD.eohbfP")).click();


	}
	
	public void enableGiftCard() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("giftCardNumber")).sendKeys("12345");
		driver.findElement(By.name("giftCardPin")).sendKeys("12345");
		
	}
	
	public void claimGiftCard() {
		driver.findElement(By.cssSelector(".sc-AxheI.fhPHUH")).click();
		String errorMessage  = driver.findElement(By.cssSelector(".sc-fzqARJ.eBcpgV")).getText().toString();
		Assert.assertEquals(errorMessage, "Error applying Gift Card");
	
		
	}
}
