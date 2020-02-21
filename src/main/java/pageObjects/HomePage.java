package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import utility.TestSetUp;
import utility.Utils;

public class HomePage extends TestSetUp{
	public static final Logger log = LogManager.getLogger(HomePage.class);	

	//Constructor for HomePage
	public HomePage(WebDriver driver, ExtentTest logger){
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		reportStep("Waiting for Home Page to load", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(lnkBuyNow));
			reportStep("Successfully landed on the  Home Page", "PASS");
		} catch (Exception e) {
			reportStep("Not able to land on the  Home  Page", "FAIL");
		} 
	}
	
	@FindBy(xpath="//a[text()='BUY NOW']")
	private static WebElement lnkBuyNow;
	
	public CheckoutPopUp clickBuyNow() {
		reportStep("Locating \"Buy Now\" Link in Home Page","INFO");
		if(Utils.click(lnkBuyNow)) {
			reportStep("Click \"Buy Now\" Link in Home Page","PASS");
		}else {
			reportStep("Unable to Click \"Buy Now\" Link in Home Page","FAIL");
		}
		return new CheckoutPopUp(driver, logger);
	}
	
	@FindBy(xpath="(//div[@class='price']/span)[2]")
	private static WebElement lblPrice;
	
	public HomePage getPrice() {
		reportStep("Locating Price Label in Home Page","INFO");
		String price=Utils.getText(driver, lblPrice);
		reportStep("Price of the product in Home Page is : " +price, "PASS");
		return this;
	}
	
	@FindBy(xpath="//span[contains(text(),'Thank you for your purchase.')]")
	private static WebElement lblThankYouPurchase;
	
	public HomePage verifyThankYouMessageIsDisplayed() {
		reportStep("Locating \"Thank you for your purchase.\" Label in Home Page","INFO");
		Utils.sleep(6000);
		boolean presence=Utils.verifyElementPresent(lblThankYouPurchase);
		if(presence) {
			reportStep(" \"Thank you for your purchase.\" Label is displayed in Home Page","PASS");
		}else {
			reportStep("\"Thank you for your purchase.\" Label is not displayed in Home Page","FAIL");
		}
		return this;
	}
}
