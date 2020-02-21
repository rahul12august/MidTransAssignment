package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utils extends TestSetUp{
	private static boolean presence=false;
	public WebDriver driver=null;
	private static String testData=null;
	static WebDriverWait  wait;	

	private static final XMLReader objXMLReader = new XMLReader(System.getProperty("user.dir") + "/src/main/java/testData/Testdata.xml");

	public static boolean jsClick(WebElement element, WebDriver driver){
		try{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			return true;
		}catch(Exception e){
			System.out.println("Unable to click element " +element);
			return false;
		}	
	}
	public static String getTestData(int index,String key){
		try {
			Log.info("Fetching Test Data for the test");
			List<Hashtable<String, String>> testDataHashTable = objXMLReader.getDataAsList("BasedOnFunctionality");
			testData= testDataHashTable.get(index).get(key).trim();
			Log.info("Successfully fetched Test Data for the test");
			return testData;
		}catch(Exception e) {
			Log.error("Unable to get Test Data: " +key);
			throw e;

		}		
	}
	
	public static void scrollingToPageElement(WebElement element,WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public static String getTestDataPath(){
		String path=System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"testData"+File.separator;
		return path;
	}

	public static void sleep(int milliSec){
		try {
			Thread.sleep(milliSec);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Boolean explicitWaitForVisibility(WebElement element) {
		Boolean presence;
		try {
			Log.info("Waiting for element: "+element+" to be Visible");
			wait.until(ExpectedConditions.visibilityOf(element));
			Log.info("Element is visible: " +element);
			return presence=true;
		}catch(Exception e) {
			return false;
		}
	}
	public static String getTimeStamp() {
		Date d = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String currentDate = sdf.format(d);
		return currentDate;
	}

	public static void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static String covertMillis(Long millis){
		long hours = TimeUnit.MILLISECONDS.toHours(millis);
		millis -= TimeUnit.HOURS.toMillis(hours);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
		millis -= TimeUnit.MINUTES.toMillis(minutes);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
		return String.format("%02d:%02d:%02d",hours, minutes,seconds);
	}
	
	public static boolean click(WebElement element) {
		try {
			Log.info("Waiting for element to be visible");
			wait.until(ExpectedConditions.visibilityOf(element));
			Log.info("Clicking on " +element);
			element.click();
			Log.info("Clicked Successfully on " +element);
			return true;	
		}

		catch(Exception e) {
			e.printStackTrace();
			Log.error("Unable to click "+element);
			return false;
		}
	}
	public static boolean sendKeys(WebElement element, String string) {
		try {
			if(element.isDisplayed()) {
				element.clear();
				Log.info("Cleared the textboxes" +element);
				element.sendKeys(string);
				Log.info("Entered successfully " +string + "in the text box" +element);
				return true;
			}

		}catch(Exception e) {
			e.printStackTrace();
			Log.error("Unable to enter " +string + "in the text box" +element);
		}
		return false;
	}
	
	public static void scrollToBottomOfPage(WebDriver driver) {
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public static String getText(WebDriver driver,WebElement element) {
		String text=null;
		try {
			Log.info("Locating element in the page" +element);
			text=element.getText().toString();
			Log.info("Text of element is : " +text);
		}catch(Exception e) {
			Log.error("Unable to retrive text");
			throw e;
		}
		
		return text;	
	}
	
	public static boolean verifyElementPresent(WebElement element) {
		Log.info("Verify Element Present. Element: "+element);
		if(element.isDisplayed()) {
			Log.info("Element is displayed.");
			presence=true;
			return true;
		}else {
			Log.error("Element is not displayed.");
			return presence;
		}
	}
	
	public static void switchToFrame(WebDriver driver,String id) {
		Log.info("Switching to iFrame");
		driver.switchTo().frame(id);
		Log.info("Successfully switched to iFrame");
	}
	
	public static void switchToFrameByIndex(WebDriver driver,int index) {
		Log.info("Switching to iFrame");
		driver.switchTo().frame(index);
		Log.info("Successfully switched to iFrame");
	}
	
	public static void switchToMainWindow(WebDriver driver) {
		Log.info("Switching to iFrame");
		driver.switchTo().defaultContent();
		Log.info("Successfully switched to iFrame");
	}
}
