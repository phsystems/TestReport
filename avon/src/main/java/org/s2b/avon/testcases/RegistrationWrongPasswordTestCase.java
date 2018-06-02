package org.s2b.avon.testcases;


import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.LogStatus;

import org.s2b.avon.framework.*;
import org.s2b.avon.tasks.*;
import org.s2b.avon.verificationpoints.*;

public class RegistrationWrongPasswordTestCase {

	private WebDriver driver;

	private HomeTask homePage; 
	private LoginTask loginPage;
	private LoginVerificationPoint verificationPoint;

	@Before
	public void setUp() {
		Reports.startTest("Register Fails");
		driver = Drives.getFirefoxDriver();
		
		homePage = new HomeTask(driver);
		loginPage = new LoginTask(driver);
		verificationPoint = new LoginVerificationPoint(driver);
	}
	
	@Test
	public void testMain() throws IOException {
		driver.get("https://www.avoncomigo.avon.com.br/widget/avonwg2/#/login");
		driver.manage().window().maximize();
		
		Reports.log(LogStatus.INFO, "The website has started.", ScreenShot.capture(driver));
		
		driver.get("https://www.avoncomigo.avon.com.br/widget/avonwg2/#/login");
		driver.manage().window().maximize();
		//this.homePage.accessRegistrationPage();
		
		Reports.log(LogStatus.INFO, "Register Page loaded.", ScreenShot.capture(driver));
		
		loginPage.fillForm("invalid", "invalid");		
		loginPage.toRegister();
		
		verificationPoint.checkInvalidLoginMessage();
	}	

	@After
	public void tearDown() {
		driver.quit();
	}
	}
