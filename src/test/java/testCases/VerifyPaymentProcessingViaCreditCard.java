package testCases;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import utility.TestSetUp;
import utility.Utils;

/**
 * @author: Rahul tiwari
 * This class comprises of two test. 
 * First: Successful Purchase of pillow using credit card as payment option.
 * Second: Unsuccessful purchase of pillow using credit card as payment option.
 */
public class VerifyPaymentProcessingViaCreditCard extends TestSetUp{
	
	/**
	 * Below test will purchase pillow using default quantity and price.
	 * Technical Complexity: There is a frame inside frame which you will be aware only after 
	 * inspecting in proper way.
	 * Test Data Used:
	 * Credit Card Number:4811 1111 1111 1114
	 * cvv: 123
	 * Expiry date:02/20
	 * password: 112233
	 */
  @Test(enabled=true)
  public void successfulPurchaseOfPillowViaCreditCard() {
	  reportStep("validation of Successful Payment Processing Via Credit Card as Payment Option... Started", "INFO");
	  new HomePage(driver, logger).
	  clickBuyNow().
	  enterName(Utils.getTestData(0, "name")).
	  enterEmail(Utils.getTestData(0, "email")).
	  enterPhoneNumber(Utils.getTestData(0, "phone")).
	  enterCity(Utils.getTestData(0, "city")).
	  enterAddress(Utils.getTestData(0, "address")).
	  enterPostalCode(Utils.getTestData(0, "pincode")).
	  clickCheckOut().
	  switchToFrame().
	  clickContinueLink().
	  clickCreditCardPaymentoption().
	  enterCardNumber(Utils.getTestData(0, "cardNumber")).
	  enterExpiryDate(Utils.getTestData(0, "expiryDate")).
	  enterCvvNumber(Utils.getTestData(0, "cvv")).
	  clickPayNow().
	  enterPassword(Utils.getTestData(0, "password")).
	  clickOk().
	  verifyThankYouMessageIsDisplayed();
	  reportStep("validation of Successful Payment Processing Via Credit Card as Payment Option... COMPLETED.", "PASS");
  }
  
  /**
	 * Below test will test unsuccessful payment processing using invalid credit card number
	 * while purchasing pillow using default quantity and price.
	 * Technical Complexity: There is a frame inside frame which you will be aware only after 
	 * inspecting in proper way.
	 * Test Data Used:
	 * Credit Card Number:4911 1111 1111 1113
	 * cvv: 123
	 * Expiry date:02/20
	 * password: 112233
	 */
@Test(enabled=true)
public void unsuccessfulPurchaseOfPillowViaCreditCard() {
	  reportStep("Validation of Unuccessful Payment Processing Via Credit Card as Payment Option... Started", "INFO");
	  new HomePage(driver, logger).
	  clickBuyNow().
	  enterName(Utils.getTestData(0, "name")).
	  enterEmail(Utils.getTestData(0, "email")).
	  enterPhoneNumber(Utils.getTestData(0, "phone")).
	  enterCity(Utils.getTestData(0, "city")).
	  enterAddress(Utils.getTestData(0, "address")).
	  enterPostalCode(Utils.getTestData(0, "pincode")).
	  clickCheckOut().
	  switchToFrame().
	  clickContinueLink().
	  clickCreditCardPaymentoption().
	  enterCardNumber(Utils.getTestData(0, "invalidCardNumber")).
	  enterExpiryDate(Utils.getTestData(0, "expiryDate")).
	  enterCvvNumber(Utils.getTestData(0, "cvv")).
	  clickPayNow().
	  enterPassword(Utils.getTestData(0, "password")).
	  clickOkFailed().
	  switchToFrame().
	  verifyCardDeclinedByBankIsDisplayed().
	  verifyTransactionfailedIsDisplayed();
	  reportStep("Validation of Unuccessful Payment Processing Via Credit Card as Payment Option... COMPLETED.", "PASS");
}
}
