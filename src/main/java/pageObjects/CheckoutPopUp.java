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

public class CheckoutPopUp extends TestSetUp{
	public static final Logger log = LogManager.getLogger(HomePage.class);	

	//Constructor for EmailContentPage
	public CheckoutPopUp(WebDriver driver, ExtentTest logger){
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		reportStep("Waiting for Checkout pop up to load", "INFO");
		try {
			wait.until(ExpectedConditions.visibilityOf(txtBxName));
			reportStep("Successfully landed on the  Checkout Pop Up", "PASS");
		} catch (Exception e) {
			reportStep("Not able to land on the  Checkout  pop up", "FAIL");
		} 
	}
	
	@FindBy(xpath="(//input)[2]")
	private static WebElement txtBxName;
	
	public CheckoutPopUp enterName(String name) {
		reportStep("locating Name Text Box in Checkout pop up","INFO");
		if(Utils.sendKeys(txtBxName, name)) {
			reportStep("Successfully Entered Name "+name+" in Text Box in Checkout pop up","PASS");
		}else {
			reportStep("Unable to Enter Name in Text Box in Checkout pop up","FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//input[@type='email']")
	private static WebElement txtBxEmail;
	
	public CheckoutPopUp enterEmail(String email) {
		reportStep("locating Email Text Box in Checkout pop up","INFO");
		if(Utils.sendKeys(txtBxEmail, email)) {
			reportStep("Successfully Entered Email: "+email+" in Text Box in Checkout pop up","PASS");
		}else {
			reportStep("Unable to Enter Email in Text Box in Checkout pop up","FAIL");
		}
		return this;
	}
	
	
	@FindBy(xpath="(//input)[4]")
	private static WebElement txtBxPhone;
	
	public CheckoutPopUp enterPhoneNumber(String number) {
		reportStep("locating Phone Text Box in Checkout pop up","INFO");
		if(Utils.sendKeys(txtBxPhone, number)) {
			reportStep("Successfully Entered Phone "+number+" in Text Box in Checkout pop up","PASS");
		}else {
			reportStep("Unable to Enter Phone in Text Box in Checkout pop up","FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="(//input)[5]")
	private static WebElement txtBxCity;
	
	public CheckoutPopUp enterCity(String city) {
		reportStep("locating City Text Box in Checkout pop up","INFO");
		if(Utils.sendKeys(txtBxCity, city)) {
			reportStep("Successfully Entered City "+city+" in Text Box in Checkout pop up","PASS");
		}else {
			reportStep("Unable to Enter City in Text Box in Checkout pop up","FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//textArea")
	private static WebElement txtAreaAddress;
	
	public CheckoutPopUp enterAddress(String address) {
		reportStep("locating City Text Box in Checkout pop up","INFO");
		if(Utils.sendKeys(txtAreaAddress, address)) {
			reportStep("Successfully Entered City "+address+" in Text Box in Checkout pop up","PASS");
		}else {
			reportStep("Unable to Enter City in Text Box in Checkout pop up","FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="(//input)[6]")
	private static WebElement txtBxPostalCode;
	
	public CheckoutPopUp enterPostalCode(String postalCode) {
		reportStep("locating Postal Code Text Box in Checkout pop up","INFO");
		if(Utils.sendKeys(txtBxPostalCode, postalCode)) {
			reportStep("Successfully Entered Postal Code "+postalCode+" in Text Box in Checkout pop up","PASS");
		}else {
			reportStep("Unable to Enter Postal Code in Text Box in Checkout pop up","FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//div[text()='CHECKOUT']")
	private static WebElement lnkCheckout;
	
	public OrderSummaryPopUp clickCheckOut() {
		reportStep("locating Check out Link Text Box in CHECK OUT pop up","INFO");
		if(Utils.click(lnkCheckout)) {
			reportStep("Successfully clicked Check Out Link in Checkout pop up","PASS");
		}else {
			reportStep("Unable to click Check Out Link in Checkout pop up","FAIL");
		}
		return new OrderSummaryPopUp(driver, logger);
	}

}
