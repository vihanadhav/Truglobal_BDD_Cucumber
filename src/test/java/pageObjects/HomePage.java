package pageObjects;

import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import utilities.Utility;

public class HomePage {

	
	WebDriver driver;
	Utility  utility;
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']") 
	WebElement searchTxt;
	
	
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	WebElement searchBtn;
	
	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	WebElement productName;
	
	@FindBy(xpath = "(//div[@id='brandsRefinements']//i)[1]")
	WebElement realmeBox;
	
	@FindBy(xpath = "(//div[@id='brandsRefinements']//i)[2]")
	WebElement samsungBox;
	
	@FindBy(xpath = "//a[@id='nav-link-accountList']")
	WebElement moveCurser;
	
	@FindBy(xpath = "(//a[text()='Start here.'])[1]")
	WebElement clickOnstarthere;
	
	@FindBy(xpath = "//input[contains(@type,'text')]")
	WebElement yourName;

	@FindBy(xpath = "//input[contains(@type,'tel')]")
	WebElement mobileNumber;
	
	@FindBy(xpath = "//input[contains(@type,'password')]")
	WebElement passWord;
	
	@FindBy(xpath = "//input[@id='continue']")
	WebElement clickOnVerifymobileNum;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		utility= new Utility(driver);
	}
	
	
	public void launchBrowser(String url)
	{
		driver.get(url);
	}
	
	
	public void searchiphone(String product)
	{
		
		
		searchTxt.clear();
		searchTxt.sendKeys(product);
		searchBtn.click();
			
	}
	
	public void selectproductFromList()
	{
			
		productName.click();
		
		 //window handle
		Set<String>  IDs=driver.getWindowHandles();
	  	 ArrayList<String>  al=new  ArrayList<String>(IDs);
	  	    String  windowID=al.get(1);
	  	   driver.switchTo().window(windowID);
    		
	}
	
    
	
	public void closeTheBrowser()
	{
		
		driver.quit();
		
	}
	
	public void filteredproduct()
	{
		
		realmeBox.click();
		samsungBox.click();
		
	}
	
	public void validateTheFilteredList()
	{
		
		utility.captureScreenShot("filteredlist");
		
		boolean actualresult1=realmeBox.isSelected();
		Assert.assertTrue(actualresult1);
		
		
		boolean actualresult2=samsungBox.isSelected();
		Assert.assertTrue(actualresult2);
		
	}
	
	public void clickOnStarthere()
	{
		Actions  act=new  Actions(driver);
		act.moveToElement(moveCurser).perform();
		clickOnstarthere.click();
		
	}
	
	public void enterYourName(String yname)
	{
		utility.waitForElement(yourName, 20);
		yourName.clear();
		yourName.sendKeys(yname);
		
	}
	
	public void enterMobileNumber(String mnumber)
	{
		utility.waitForElement(mobileNumber, 20);
		mobileNumber.clear();
		mobileNumber.sendKeys(mnumber);
		
	}
	
	public void enterPassword(String pwd)
	{
		utility.waitForElement(passWord, 20);
		passWord.clear();
		passWord.sendKeys(pwd);
		
	}
	
	public void clickVerifyMobileNumber() throws InterruptedException
	{
		utility.waitForElement(clickOnVerifymobileNum, 20);
		clickOnVerifymobileNum.click();
		Thread.sleep(5000);
		
		utility.captureScreenShot("verifynumber");
	}
	
	
}
