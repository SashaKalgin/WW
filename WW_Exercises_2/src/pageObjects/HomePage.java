package pageObjects;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

	private String baseURL = "https://www.weightwatchers.com/us/";
	private By buttonFindStudio = By.id("ela-menu-visitor-desktop-supplementa_find-a-studio");

	public String getBaseURL() {		
		return this.baseURL;
	}
	public void goHomePage(WebDriver driver) {
		if(isValid(getBaseURL())){
			driver.get(getBaseURL());
		}else
			System.out.println("URL is invalid!");			
	}

	public static boolean isValid(String url) 
	{ 
		/* Try creating a valid URL */
		try { 
			new URL(url).toURI(); 
			return true; 
		}         
		// If there was an Exception 
		// while creating URL object 
		catch (Exception e) { 
			return false; 
		} 
	} 

	public void verifyHomePageByTitel(WebDriver driver) {
		Assert.assertEquals("WW (Weight Watchers): Weight Loss & Wellness Help", driver.getTitle());	
	}

	public void clickFindStudio(WebDriver driver) {
		if(driver.findElements(buttonFindStudio).size() != 0){
			driver.findElement(buttonFindStudio).click();
		}else
			System.out.println("The button 'Find a Studio' at home page is unavailable!");
	}



}
