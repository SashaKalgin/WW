package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import management.DriverManager;
import management.DriverManagerFactory;
import management.DriverManagerFactory.DriverType;
import pageObjects.HomePage;
import pageObjects.MeetingPage;

public class SomeScenario {
	
	private DriverManager driverManager;
	private WebDriver driver;
	private HomePage homePage = new HomePage();
	private MeetingPage meetingPage = new MeetingPage();
    

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
    }
 
    @AfterTest
    public void afterMethod() {
        driverManager.quitDriver();
    }
    
    @Test
    public void someTest() {
    	homePage.goHomePage(driver);
    	homePage.verifyHomePageByTitel(driver);
    	homePage.clickFindStudio(driver);
    	meetingPage.verifyFindMeetingPageByTitle(driver);
    	meetingPage.searchMeetingsByZipCode(driver);
    	meetingPage.printTitleFirstResultDistance(driver);
    	meetingPage.clickFirstSearchResult(driver);
    	meetingPage.printTodayHours(driver);
    	meetingPage.printNumberMeetingEachPerson(driver);
    	
    }


}
