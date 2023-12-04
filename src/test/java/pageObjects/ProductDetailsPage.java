package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utility;

public class ProductDetailsPage {
	
	
	WebDriver driver;
	Utility utility;
	
	@FindBy(xpath = "(//div[@id='centerCol']//span)[22]")
	WebElement productPrice;
	
	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	WebElement addToCartBtn;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utility = new Utility(driver);
	}
	
	
	public void getProductDetailsPage() 
    {
    	 
		  utility.waitForElement(productPrice, 20);
    	  String productprice=productPrice.getText();
    	  System.out.println("******************Product Price ="+productprice);
    
    }
    
	public void addProductToCart()
	{
		
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
		
		   Actions  act=new  Actions(driver);
		  act.moveToElement(addToCartBtn).perform();
		       addToCartBtn.click();
	}

}
