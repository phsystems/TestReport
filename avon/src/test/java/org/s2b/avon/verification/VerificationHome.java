package org.s2b.avon.verification;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.s2b.avon.framework.Reports;
import org.s2b.avon.framework.ScreenShot;

import com.relevantcodes.extentreports.LogStatus;

public class VerificationHome {

	private WebDriver driver;

	public void VerificationLogin(WebDriver driver) { 
		this.driver = driver;
	}

	public void checkHomeMessage() throws InterruptedException {
		Thread.sleep(2000);
		final String expectedMessage = "Bem-vindo à Avon Campanha 10";
		assertTrue(this.driver.getTitle().contains(expectedMessage));
		
		
		if (this.driver.getTitle().contains("expectedMessage")) {
			System.out.println("Encontrou");
			Reports.log(LogStatus.PASS, "Encontrou", ScreenShot.capture(driver));

		} else {
			Reports.log(LogStatus.PASS, "Não Encontrou", ScreenShot.capture(driver));
		}
		System.out.println("Não encontrou");
	}

}
