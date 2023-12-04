package utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Utility {
	
	
    public WebDriver driver;
	
	public Utility(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public void waitForElement(WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	

	
	public void captureScreenShot(String name)  {
		
	   File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   File destFile = new File("target/screenshots/"+name+".jpg");
		try {
			FileHandler.copy(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

