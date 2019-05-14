package pageObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MeetingPage {

	private By meetingSearch = By.id("meetingSearch");
	//private By buttonSearch = By.className("btn spice-translated"); // Error : invalid selector: Compound class names not permitted (I used cssSelector!)
	private By buttonSearch = By.cssSelector(".btn.spice-translated");
	private String zipCode = "10011";
	private By firstLocationName = By.className("location__name");
	private String titleFirstItemInList = "";
	//private By hoursListItemDay = By.className("hours-list-item-wrapper hours-list--currentday"); // Error : invalid selector: Compound class names not permitted (I used cssSelector!)
	private By currentDay = By.cssSelector(".hours-list-item-wrapper.hours-list--currentday");
	private By scheduleDetail = By.className("schedule-detailed");
	private List<WebElement> listLeaders = null;
	Map<String,Integer> m = null;


	public void verifyFindMeetingPageByTitle(WebDriver driver) {
		Assert.assertEquals(true,driver.getTitle().contains("Studios & Meetings Near You | WW USA"));
	}

	public void searchMeetingsByZipCode(WebDriver driver) {
		if(driver.findElements(meetingSearch).size() != 0){
			driver.findElement(meetingSearch).clear();
			driver.findElement(meetingSearch).sendKeys(zipCode);
			clickSearch(driver);
		}else
			System.out.println("The field for search location at meeting page is unavailable!");

	}

	public void clickSearch(WebDriver driver) {
		if(driver.findElements(buttonSearch).size() != 0){
			driver.findElement(buttonSearch).click();
		}else
			System.out.println("The button for search at meeting page is unavailable!");
	}

	public void printTitleFirstResultDistance(WebDriver driver) {
		driver.findElement(By.cssSelector("body"));
		if(driver.findElements(firstLocationName).size() != 0){
			titleFirstItemInList = driver.findElements(firstLocationName).get(0).getText();
			System.out.println("The first name of location in the list is: " + titleFirstItemInList);
		}else
			System.out.println("The list is unavailable!");
	}

	public void clickFirstSearchResult(WebDriver driver) {
		if(driver.findElements(firstLocationName).size() != 0){
			driver.findElements(firstLocationName).get(0).click();
			String locationName = driver.findElement(By.className("location__name")).getText();
			if(titleFirstItemInList.equals(locationName)){
				System.out.println("The title of first item in the list match to the location name.");
			}else{
				System.out.println("The title of first item in the list doesn't match to the location name.");
			}

		}else
			System.out.println("The name of location is unavailable!");

	}

	public void printTodayHours(WebDriver driver) {
		driver.findElement(By.cssSelector("body"));
		if(driver.findElements(currentDay).size() != 0){
			System.out.println(driver.findElement(currentDay).getText());
		}else
			System.out.println("The operation list of hours is unavailable!");		
	}

	public void printNumberMeetingEachPerson(WebDriver driver) {
		if(driver.findElements(scheduleDetail).size() != 0){
			listLeaders = driver.findElements(By.className("schedule-detailed-day-meetings-item-leader"));
			m = new HashMap<String,Integer>();
			System.out.println("The number of meeting the each person:");
			int cnt = 0;
			String name = "";
			for(WebElement element:listLeaders){
				name = element.getText();
				cnt = 0;
				for(WebElement ele:listLeaders){
					if(name.equals(ele.getText()))
						cnt++;
				}
				m.put(name, cnt);
			}

			for (Map.Entry<String, Integer> entry : m.entrySet()) {
				System.out.print(entry.getKey() + " ");
				System.out.println(entry.getValue());

			}	
		}else
			System.out.println("The Schedule Detail table is unavailable!");

	}

}

