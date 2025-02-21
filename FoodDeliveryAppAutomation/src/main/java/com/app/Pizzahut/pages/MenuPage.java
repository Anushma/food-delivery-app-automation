package com.app.Pizzahut.pages;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
	WebDriver driver;

    // Locators
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div[2]/a") 
    WebElement pizzaMenuButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div/a[2]/div[3]/div/button")
    WebElement addPizzaButton;

    @FindBy(xpath = "//button[contains(text(),'Drinks')]") 
    WebElement drinksMenuButton;

    @FindBy(xpath = "//div[@class='drink-item']//button[contains(text(),'Pepsi')]") 
    WebElement addPepsiButton;
    
    @FindBy(name = "toggle-button-0")
    WebElement toogleButton;

    // Constructor
    public MenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods
    public void clickDrinkMenu() {
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	 driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/a[5]")).click();
    
     
    }
    
    public void clickDrinkFrom() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/a[7]")) .click() ;
    }

    
    public void clickSidesMenu() {
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/a[4]")).click();
    	 
  
    }
    
    public void addSidesToBasket() {
 
 
     driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div/a[1]/div[3]/div/button")).click();
    }
    
    public void addPizzaToCart() {
        addPizzaButton.click();
    }

    public void clickDrinksMenu() {
        drinksMenuButton.click();
    }

    public void addPepsiToCart() {
        addPepsiButton.click();
    }
    
    public void validateVegOption() {
    	boolean selected = toogleButton.isSelected();
    	Assert.assertFalse(selected);
    }
    
    public void addDrink() {
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    	driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div/a[2]")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    	driver.findElement(By.xpath("//*[@id=\"product\"]/div[2]/div[3]/button")).click();
       	
    }
    
    public void clickonPizzaMenu() {
    	driver.findElement(By.linkText("Pizzas")).click();
    }
    
    public void addFirstPizza() {
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    	List<WebElement> elements = driver.findElements(By.cssSelector("button.button--md.button--green.flex-1.font-semibold"));
    	elements.get(1).click();
    
    }
    
   
    
    
}

