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

public class PaymentPopUp extends TestSetUp{
	public static final Logger log = LogManager.getLogger(PaymentPopUp.class);	

	//Constructor for EmailContentPage
	public PaymentPopUp(WebDriver driver, ExtentTest logger){
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		reportStep("Waiting for Payment Details pop up to load", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(lnkPayNow));
			reportStep("Successfully landed on the Payment Details Pop Up", "PASS");
		} catch (Exception e) {
			reportStep("Not able to land on the Payment Details pop up", "FAIL");
		} 
	}
	
	@FindBy(name="cardnumber")
	private static WebElement txtbxCardNumber;
	
	public PaymentPopUp enterCardNumber(String cardNumber) {
		reportStep("Locating Card Number text box in Payment Details Pop Up", "INFO");
		if(Utils.sendKeys(txtbxCardNumber, cardNumber)) {
			reportStep("Successfully entered Card Number : "+cardNumber+" in text box in Payment Details Pop Up", "PASS");
		}else {
			reportStep("Unable to enter Card Number in text box in Payment Details Pop Up", "INFO");
		}
		return this;
	}
	
	@FindBy(xpath="//input[@placeholder='MM / YY']")
	private static WebElement txtBxExpiryDate;
	
	public PaymentPopUp enterExpiryDate(String expiryDate) {
		reportStep("Locating Expiry Date text box in Payment Details Pop Up", "INFO");
		if(Utils.sendKeys(txtBxExpiryDate, expiryDate)) {
			reportStep("Successfully entered Expiry Date : "+expiryDate+" in text box in Payment Details Pop Up", "PASS");
		}else {
			reportStep("Unable to enter Expiry Date in text box in Payment Details Pop Up", "INFO");
		}
		return this;
	}
	
	@FindBy(xpath="//input[@inputmode='numeric']")
	private static WebElement txtBxCvvNumber;
	
	public PaymentPopUp enterCvvNumber(String cvvNumber) {
		reportStep("Locating Cvv Number text box in Payment Details Pop Up", "INFO");
		if(Utils.sendKeys(txtBxCvvNumber, cvvNumber)) {
			reportStep("Successfully entered Cvv Number : "+cvvNumber+" in text box in Payment Details Pop Up", "PASS");
		}else {
			reportStep("Unable to enter Cvv Number in text box in Payment Details Pop Up", "INFO");
		}
		return this;
	}
	
	@FindBy(xpath="(//div[@id='app']//a)[2]")
	private static WebElement lnkPayNow;
	
	public PasswordPopUp clickPayNow() {
		reportStep("Locating Cvv Number text box in Payment Details Pop Up", "INFO");
		if(Utils.click(lnkPayNow)) {
			reportStep("Successfully clicked Pay Now link in Payment Details Pop Up", "PASS");
		}else {
			reportStep("Unable to click Pay Now link in Payment Details Pop Up", "INFO");
		}
		return new PasswordPopUp(driver, logger);
	}
}
