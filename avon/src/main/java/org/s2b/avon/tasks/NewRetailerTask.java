package org.s2b.avon.tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.s2b.avon.appobjects.NewRetailerAppObject;

public class NewRetailerTask {
	private NewRetailerAppObject newRetailer;

	private WebDriver webDriver;
	private long timeoutInSeconds;
	
	WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
	public NewRetailerTask(WebDriver driver) {
		this.newRetailer = new NewRetailerAppObject(driver);
	}
	public void newFillForm (String firstName, String lastName, String dateOfBirth, String cpfNumber, String email, String confEmail, String dayPhoneOne, String dayPhoneTwo, String mobPhoneOne, String mobPhoneTwo, String postcode, String addressOne, String addressTwo, String addressThree, String strNeighborhood) {
		
		newRetailer.getFirstNameTextField().sendKeys(firstName);
		newRetailer.getlastNameeTextField().sendKeys(lastName);
		newRetailer.getDateOfBirthTextField().sendKeys(dateOfBirth);
		newRetailer.getCpfNumberTextField().sendKeys(cpfNumber);
		newRetailer.getEmailTextField().sendKeys(email);
		newRetailer.getConfEmailTextField().sendKeys(confEmail);
		newRetailer.getDDDHousePhoneOneTextField().sendKeys(dayPhoneOne);
		newRetailer.getHousePhoneOneTextField().sendKeys(dayPhoneTwo);
		newRetailer.getDDDCellPhoneOneTextField().sendKeys(mobPhoneOne);
		newRetailer.getCellPhoneOneTextField().sendKeys(mobPhoneTwo);
		newRetailer.getCEPTextField().sendKeys(postcode);
		//newRetailer.getTownTextField().wait(ExpectedConditions.invisibilityOfElementLocated("towr"));
		newRetailer.getAddressStreetTextField().sendKeys(addressOne);
		newRetailer.getAddressNumberTextField().sendKeys(addressTwo);
		newRetailer.getFullAddressTextField().sendKeys(addressThree);
		newRetailer.getNeighborhoodTextField().sendKeys(strNeighborhood);
		newRetailer.getTermAndConditions().click();
			
	}
	public void acessRetailerSearch() {
		newRetailer.getCreateButton().click();
	}
 
		
}
