package stepsDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;

public class Steps {
	
	
	public WebDriver driver;
	public HomePage homePage;
	public ProductDetailsPage detailsPage;

	@Given("User launch the chrome browser with URL {string}")
	public void user_launch_the_chrome_browser_with(String url) {
		
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().window().maximize();
        homePage=new HomePage(driver);
        detailsPage=new ProductDetailsPage(driver);
		driver.get(url);
	}

	
	@When("User search the {string}")
	public void user_search_the(String product) {
		
		homePage.searchiphone(product);
	}


	@Then("User select product from product list")
	public void user_select_product_from_product_list() {
		homePage.selectproductFromList();
	}

	@And("User see product details page and store the price in variable")
	public void user_see_product_details_page_and_store_the_price_in_variable()  {
	    
		detailsPage.getProductDetailsPage();
		
	}

	@And("User click on add to cart button")
	public void user_click_on_add_to_cart_button() {
	    
		detailsPage.addProductToCart();
		
	}

	@And("Close the browser")
	public void close_the_browser() {
		
		homePage.closeTheBrowser();
	    
	}
	


	@When("User add the filters")
	public void user_add_the_filters() {
		
		homePage.filteredproduct();

	}

	@Then("Validate the filtered list")
	public void validate_the_filtered_list() {
		
		homePage.validateTheFilteredList();
	}
 
	 

	@When("User hover and click on Start here. link")
	public void user_click_on_start_here_link() {
		
		homePage.clickOnStarthere();
		
	}

		

	@When("User enters Your name as {string}, Mobile number as {string} and Password as {string}")
	public void user_enters_your_name_as_mobile_number_as_and_password_as(String yourname, String mobilenumber, String password) {
		
		   homePage.enterYourName(yourname);
		   homePage.enterMobileNumber(mobilenumber);
		   homePage.enterPassword(password);
	}

	@And("User click on Verify mobile number button")
	public void user_click_on_verify_mobile_number_button() throws InterruptedException {
		
		homePage.clickVerifyMobileNumber();
		
	}


}
