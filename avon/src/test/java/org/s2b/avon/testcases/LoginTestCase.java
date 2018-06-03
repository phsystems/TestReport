package org.s2b.avon.testcases;


import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.s2b.avon.framework.Drives;
import org.s2b.avon.framework.Reports;
import org.s2b.avon.framework.ScreenShot;
import org.s2b.avon.tasks.HomeTask;
import org.s2b.avon.tasks.LoginTask;
import org.s2b.avon.verification.VerificationHome;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class LoginTestCase {
	private WebDriver driver;
	private HomeTask homePage;
	private LoginTask logintask;
	private VerificationHome verificationhome;
	public LoginTask getLogintask() {
		return logintask;
	}

	public void setLogintask(LoginTask logintask) {
		this.logintask = logintask;
	}

	public HomeTask getHomePage() {
		return homePage;
	}

	public void setHomePage(HomeTask homePage) {
		this.homePage = homePage;
	}

	@BeforeTest
	public void setUp() {
		
		Reports.startTest("Login");
		
		this.driver = Drives.getFirefoxDriver();
	
	}
	@Test
	public void AccessLoginTest(){
		
		driver.get("https://www.avoncomigo.avon.com.br/widget/avonwg2/#/login");
		driver.manage().window().maximize();
		Assert.assertEquals ("Bem-Vindo(a) Revendedor(a)", driver.getTitle());
		try {
			Reports.log(LogStatus.INFO, "Pagina de Login", ScreenShot.capture(driver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verificationhome.checkHomeMessage();
	
		Reports.close();
	}
	@Test
	public void HomeTest(){
		driver.get("http://www.avon.com.br/");
		driver.manage().window().maximize();
		try {
			Reports.log(LogStatus.INFO, "Pagina de Inicial", ScreenShot.capture(driver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.homePage.accessRegistrationPage();
		Reports.close();
	}
	
	@Test
	public void LoginTest(){
		
		driver.get("https://www.avoncomigo.avon.com.br/widget/avonwg2/#/login");

		logintask.fillForm("65846980", "6965fi");
		try {
			Reports.log(LogStatus.INFO, "Inserção dados Usuario e Senha", ScreenShot.capture(driver));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals("hello", driver.findElement(By.cssSelector("#btn-profile > span.hello")));
				}
	@AfterMethod
	 public void getResult(ITestResult result){
		Reports.Result(result);
	}
	@AfterClass
	public void tearDown() {
		Reports.close();
		this.driver.quit();
	}
}


