package com.app.Pizzahut.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class CartPage {
	WebDriver driver;

    // Locators
    @FindBy(id = "cart-items") 
    WebElement cartItems;

    @FindBy(id = "total-price")
    WebElement totalPrice;


    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods
    public boolean isItemAdded() {
        return cartItems.isDisplayed();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public void removePizzaFromCart() {
    	driver.findElement(By.cssSelector(".icon-close.relative.opacity-25.text-grey.ml-10.p-10")).click();
    }

    public void proceedToCheckout() {
   	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
     driver.findElement(By.cssSelector(".button.button--primary.justify-between")).click();
    }

    
    public void itemsCheckInCart() {
    	WebElement element = driver.findElement(By.cssSelector(".bg-green-dark.pl-5.pr-5.rounded"));
    	String count = element.getText();
        assertEquals(count, "2 item");
    	
    }
    
    public void minimumorderAlert() {
    	WebElement element = driver.findElement(By.cssSelector(".typography-2.mt-30"));
    	String minOrderAlert = element.getText();
    	assertTrue(minOrderAlert.contains("You're only"));
    	
    }
}

