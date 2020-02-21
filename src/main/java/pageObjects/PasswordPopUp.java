package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import utility.TestSetUp;
import utility.Utils;

public class PasswordPopUp extends TestSetUp{
	public static final Logger log = LogManager.getLogger(PasswordPopUp.class);	

	//Constructor for EmailContentPage
	public PasswordPopUp(WebDriver driver, ExtentTest logger){
		this.driver = driver;
		this.logger = logger;
		PageFactory.initElements(driver, this);
		reportStep("Waiting for Bank Password pop up to load", "INFO");
		try {
			Utils.sleep(5000);
			Utils.switchToFrameByIndex(driver, 0);
			reportStep("Successfully landed on the Bank Password Pop Up", "PASS");
		} catch (Exception e) {
			reportStep("Unable to land on the Bank Password pop up", "FAIL");
		} 
	}
	
	@FindBy(id="PaRes")
	private static WebElement txtbxPassword;
	
	public PasswordPopUp enterPassword(String password) {
		reportStep("Locating Password text box in Bank Password Pop Up", "INFO");
		if(Utils.sendKeys(txtbxPassword, password)) {
			reportStep("Successfully entered Password : "+password+" in text box in Bank Password Pop Up", "PASS");
		}else {
			reportStep("Unable to enter Password in text box in Bank Password Pop Up", "FAIL");
		}
		return this;
	}
	
	@FindBy(xpath="//button[text()='OK']")
	private static WebElement btnOk;
	
	public HomePage clickOk() {
		reportStep("Locating Ok button in Bank Password Pop Up", "INFO");
		if(Utils.jsClick(btnOk, driver)) {
			reportStep("Successfully clicked Ok button in Bank Password Pop Up", "PASS");
		}else {
			reportStep("Unable to click Ok button in Bank Password Pop Up", "FAIL");
		}
		Utils.switchToMainWindow(driver);
		return new HomePage(driver, logger);
	}
	
	public PasswordPopUp clickOkFailed() {
		reportStep("Locating Ok button in Bank Password Pop Up", "INFO");
		if(Utils.jsClick(btnOk, driver)) {
			reportStep("Successfully clicked Ok button in Bank Password Pop Up", "PASS");
		}else {
			reportStep("Unable to click Ok button in Bank Password Pop Up", "FAIL");
		}
		Utils.switchToMainWindow(driver);
		return this;
	}
	
	@FindBy(xpath="//span[text()='Transaction failed']")
	private static WebElement lblTransactionfailed;
	
	public PasswordPopUp verifyTransactionfailedIsDisplayed() {
		reportStep("Locating \"Transaction Failed.\" Label Error Message in post clicking Ok Button.","INFO");
		boolean presence=Utils.verifyElementPresent(lblTransactionfailed);
		if(presence) {
			reportStep(" \"Transaction Failed.\" Label Error Message is displayed in  post clicking Ok Button.","PASS");
		}else {
			reportStep("\"Transaction Failed.\" Label Error Message is not displayed in  post clicking Ok Button.","FAIL");
		}
		return this;
	}
	
	
	@FindBy(xpath="//span[text()='Your card got declined by the bank']")
	private static WebElement lblcardDeclinedByBank;
	
	public PasswordPopUp verifyCardDeclinedByBankIsDisplayed() {
		reportStep("Locating \"Your card got declined by the bank\" Label Error Message in post clicking Ok Button.","INFO");
		boolean presence=Utils.verifyElementPresent(lblTransactionfailed);
		if(presence) {
			reportStep(" \"Your card got declined by the bank\" Label Error Message is displayed in  post clicking Ok Button.","PASS");
		}else {
			reportStep("\"Your card got declined by the bank\" Label Error Message is not displayed in  post clicking Ok Button.","FAIL");
		}
		return this;
	}
	
	public PasswordPopUp switchToFrame() {
		reportStep("Switching to first frame.","INFO");
		Utils.switchToFrameByIndex(driver, 0);
		reportStep("Successfully switched to first frame.","PASS");
		return this;
	}
}
