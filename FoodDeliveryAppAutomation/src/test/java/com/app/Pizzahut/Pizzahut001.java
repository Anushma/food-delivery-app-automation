package com.app.Pizzahut;


import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.app.Pizzahut.pages.CartPage;
import com.app.Pizzahut.pages.Checkout;
import com.app.Pizzahut.pages.HomePage;
import com.app.Pizzahut.pages.MenuPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;



public class Pizzahut001 {
	
	private ChromeDriver driver;
	private HomePage homePage;
	private MenuPage menuPage;
	private CartPage cartPage;
	private Checkout checkOutPage;
	    
	@BeforeSuite
	public void setup() {
	   
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	    driver.manage().window().maximize();

	    // Read URL from Excel
	    String excelPath = "src/test/resources/testData.xlsx";
	    String appURL = ExcelReader.getApplicationURL(excelPath, "Sheet1", 1, 1);
	    
	    driver.get(appURL);
		homePage = new HomePage(driver);
		menuPage = new MenuPage(driver);
		cartPage = new CartPage(driver);
		checkOutPage = new Checkout(driver);
	
	}
	
	@Test(priority = 1)
	public void setDeliveryLocation() {
		// type in location
		String location = "Forum Mall Bangalore";
		homePage.enterLocation(location);
		homePage.selectFirstLocation();
	}
	
	
	@Test(priority = 2)
	public void selectSides() {
		homePage.validateDetailsPage();
		menuPage.clickSidesMenu();
		menuPage.addSidesToBasket();
		
	}
	
	@Test (priority = 3)
	public void selectDrinks() {
		menuPage.clickDrinkFrom();
		menuPage.addDrink();
		menuPage.addDrink();
		
	}
	
	@Test(priority = 4)
	public void performCheckOut() {
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		  cartPage.proceedToCheckout();
	}
	
	@Test (priority = 5)
	public void applyGiftCardPromo() {
		checkOutPage.clickApplyGiftCard();
		checkOutPage.enableGiftCard();
		checkOutPage.claimGiftCard();
		
	}
	
	@Test
	public void returnToBasket() {
		
	}
	
	
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}


}
