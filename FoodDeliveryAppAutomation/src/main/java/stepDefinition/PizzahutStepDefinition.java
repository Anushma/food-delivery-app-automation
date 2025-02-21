package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.app.Pizzahut.pages.CartPage;
import com.app.Pizzahut.pages.HomePage;
import com.app.Pizzahut.pages.MenuPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PizzahutStepDefinition {

	    WebDriver driver;
	    HomePage homePage;
	    MenuPage menuPage;
	    CartPage cartPage;

	    @Given("User launches Pizzahut application with {string}")
	    public void user_launches_pizzahut_application_with(String url) {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get(url);

	        homePage = new HomePage(driver);
	        menuPage = new MenuPage(driver);
	        cartPage = new CartPage(driver);

	    }



	    @Then("User types address as {string}")
	    public void user_types_address_as(String address) {
	        homePage.enterLocation(address);
	    }

	    @And("User selects the first auto-populated drop-down option")
	    public void user_selects_auto_populated_option() {
	        homePage.selectFirstLocation();
	    }

	    @When("User navigates to the details page")
	    public void user_navigates_to_details_page() {
	       homePage.validateDetailsPage();
	    }


	    @And("User clicks on the Pizzas menu option")
	    public void user_clicks_pizzas_menu() {
	        menuPage.clickDrinkMenu();
	    }

	    @When("User selects add button of any pizza")
	    public void user_adds_pizza_to_cart() {
	        menuPage.addDrink();
	    }

	    @Then("User clicks on Drinks option")
	    public void user_clicks_on_drinks() {
	        menuPage.clickonPizzaMenu();
	    }

	    @And("User selects Pepsi option to add into the Basket")
	    public void user_adds_pepsi_to_cart() {
	        menuPage.addFirstPizza();

	    }
	    
	    @And("User sees 2 item in checkout button")
	    public void user_validates_one_item_in_checkout() {
	    	cartPage.itemsCheckInCart();

	    }

	    @Then("User removes the Pizza item from the Basket")
	    public void user_removes_pizza_from_cart() {
	        cartPage.removePizzaFromCart();

	    }

	    @Then("User clicks on Checkout button")
	    public void user_clicks_checkout_button() {
	        cartPage.proceedToCheckout();

	    }

	    @And("User sees minimum order required pop-up displayed")
	    public void user_sees_minimum_order_popup() {
	        cartPage.minimumorderAlert();
	    }
	

}
