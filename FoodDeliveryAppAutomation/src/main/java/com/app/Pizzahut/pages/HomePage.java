package com.app.Pizzahut.pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
    Actions actions;

    // Locators
 
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[1]/input")
    WebElement locationInputBox;
    @FindBy(xpath = "//button[@id='search-location']") 
    WebElement searchButton;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    
    // Methods
   
    public void enterLocation(String location) {
        locationInputBox.sendKeys(location);
      
    }
    
    public boolean validateDealsPage() {
		String URL = "https://www.pizzahut.co.in/order/deals/";
    	boolean until = new WebDriverWait(driver, Duration.ofSeconds(5)).
				until(ExpectedConditions.urlToBe(URL));
    	return until;
 
		
	}
    
 

    public void selectFirstLocation() {
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        List<WebElement> options = driver.findElements(By.cssSelector("[role='option']"));
        // Select a specific element from the list (e.g., the first element)
        WebElement specificOption = options.get(0);
        specificOption.click();
    }
    
    public void validateDetailsPage() {
    	
    	String Url = "https://www.pizzahut.co.in/order/deals/";
    	Assert.assertTrue(Url, true);
    }  
    
    public void selectSides() {
    	driver.findElement(By.cssSelector("a[href='/order/drinks']"));
    	
    }
}

