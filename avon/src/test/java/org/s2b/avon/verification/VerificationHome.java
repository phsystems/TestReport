package org.s2b.avon.verification;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.s2b.avon.framework.Reports;
import org.s2b.avon.framework.ScreenShot;

import com.relevantcodes.extentreports.LogStatus;

public class VerificationHome {

	private WebDriver driver;

	public void VerificationLogin(WebDriver driver) {
		this.driver = driver;
	}

	public void checkHomeMessage() {

		if (this.driver.getTitle().contains("Bem-Vindo(a) Revendedor(a)")) {
			System.out.println("Encontrou");
			Reports.log(LogStatus.PASS, "Encontrou", ScreenShot.capture(driver));

		} else {
			Reports.log(LogStatus.PASS, "Encontrou", ScreenShot.capture(driver));
		}
		System.out.println("Não encontrou");
	}
	// também funcionaria da forma abaixo
	// final String expectedMessage = "Bem-Vindo(a) Revendedor(a)";
	// assertTrue(this.driver.getTitle().contains(expectedMessage));

}
