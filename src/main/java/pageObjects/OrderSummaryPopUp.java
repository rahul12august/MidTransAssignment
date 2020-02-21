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

public class OrderSummaryPopUp extends TestSetUp{
	public static final Logger log = LogManager.getLogger(OrderSummaryPopUp.class);	

	//Constructor for EmailContentPage
	public OrderSummaryPopUp(WebDriver driver, ExtentTest logger){
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		reportStep("Waiting for Order Summary pop up to load", "INFO");
		try {
			//wait.until(ExpectedConditions.visibilityOf(lnkContinue));
			reportStep("Successfully landed on the  Order Summary Pop Up", "PASS");
		} catch (Exception e) {
			reportStep("Not able to land on the  Order Summary  pop up", "FAIL");
		} 
	}
	
	@FindBy(xpath="//iframe")
	private static WebElement iFrameContinueLink;
	
	@FindBy(xpath="//a[contains(@href,'payment')]")
	private static WebElement lnkContinue;
	
	public OrderSummaryPopUp switchToFrame() {
		reportStep("Switching to first frame.","INFO");
		Utils.switchToFrame(driver, "snap-midtrans");
		reportStep("Successfully switched to first frame.","PASS");
		return this;
	}
	public OrderSummaryPopUp clickContinueLink() {
		reportStep("Locating Continue Link in Order Summary pop up.", "INFO");
		if(Utils.click(lnkContinue)) {
			reportStep("Successfully clicked Continue Link in Order Summary pop up.", "PASS");
		}else {
			reportStep("Unable to click Continue Link in Order Summary pop up.", "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="(//div[@class='list-content']/div)[3]")
	private static WebElement lnkCreditCardPaymentOption;
	
	public PaymentPopUp clickCreditCardPaymentoption() {
		reportStep("Locating \"Credit Card\" Payment Option in pop up.", "INFO");
		if(Utils.click(lnkCreditCardPaymentOption)) {
			reportStep("Successfully clicked \"Credit Card\" Payment Option in pop up.", "PASS");
		}else {
			reportStep("Unable to click \"Credit Card\" Payment Option in pop up.", "FAIL");
		}
		return new PaymentPopUp(driver, logger);
	}

}
