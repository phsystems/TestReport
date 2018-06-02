package org.s2b.avon.verificationpoints;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.LogStatus;

import org.s2b.avon.framework.*;
public class LoginVerificationPoint {
private static final String INVALID_LOGIN_MESSAGE = "Seu Registro/Asc ou senha estão incorretos. Por favor, tente novamente.";
	
	private WebDriver driver;
	
	public LoginVerificationPoint(WebDriver driver) {
		this.driver = driver;
	}
	
	public void checkInvalidLoginMessage() throws IOException {
		if(this.pageContains(INVALID_LOGIN_MESSAGE)) {
			Reports.log(LogStatus.PASS, "Mensagem exibida corretamente.", ScreenShot.capture(driver));
		} else {
			Reports.log(LogStatus.FAIL, "Mensagem nao exibida conforme esperado.", ScreenShot.capture(driver));
		} 
	}

	private boolean pageContains(String text){
		return this.driver.getPageSource().contains(text);
	} 

}
