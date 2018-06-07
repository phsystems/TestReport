package org.s2b.avon.tasks;

import org.openqa.selenium.WebDriver;
import org.s2b.avon.appobjects.NewRetailerAppObject;

public class NewRetailerTask {
	public static final String NewRetailer_URL = "https://www.br.avon.com/PRSuite/applyToBeRep.page?utm_source=brandsite&utm_medium=seja-um-revendedor&utm_campaign=revender";
	
	
	private NewRetailerAppObject newRetailer; 
	private WebDriver driver;

	

	
	public NewRetailerTask(WebDriver driver) { 
		this.newRetailer = new NewRetailerAppObject(driver);
		this.driver = driver;
	}
	public void fiillCep(String CEP) {
		newRetailer.getCEPTextField().sendKeys(CEP);
	}
	public void newFillForm (String firstName, String lastName, String dateOfBirth, String cpfNumber, String email, String confEmail, String dayPhoneOne, String dayPhoneTwo, String mobPhoneOne, String mobPhoneTwo, String addressOne, String addressTwo, String strNeighborhood) {
		
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
		newRetailer.getAddressStreetTextField().sendKeys(addressOne);
		newRetailer.getAddressNumberTextField().sendKeys(addressTwo);
		newRetailer.getNeighborhoodTextField().sendKeys(strNeighborhood);
		newRetailer.getTermAndConditions().click();
			
	}
	public void acessRetailerSearch() {
		newRetailer.getCreateButton().click();
	}
	
	public void newRetailerToPage() {
		this.driver.get(NewRetailer_URL);
	}
 
		
}
