package org.s2b.avon.testcases;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.s2b.avon.framework.Drives;
import org.s2b.avon.framework.ScreenShot;
import org.s2b.avon.tasks.HomeTask;
import org.s2b.avon.tasks.LoginTask;
import org.s2b.avon.verificationpoints.LoginVerificationPoint;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTestCase {
	private WebDriver driver;
	private HomeTask homePage;
	private LoginTask logintask;
	private LoginVerificationPoint verificationPoint;
	ExtentReports extent;
	ExtentTest logger;

	@Before
	public void setUp() {
		
		this.driver = Drives.getFirefoxDriver();
		homePage = new HomeTask(driver);
		logintask = new LoginTask(driver);
		verificationPoint = new LoginVerificationPoint(driver);
	}
	@BeforeTest
	public void startTest() {

		this.extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/STMExtentReport.html", true);
		this.extent.addSystemInfo("Host Name", "Avon.com");
		this.extent.addSystemInfo("Environment", "Teste Codigo");
		this.extent.addSystemInfo("User Name", "Fabio e Pedro Henrique");
		this.extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}

	@Test
	public void passTest(){
		driver.get("http://www.avon.com.br/");
		driver.manage().window().maximize();
		logger = extent.startTest("para ser home avon");
		logger.log(LogStatus.INFO, "The website has started.", ScreenShot.capture(driver));
		// this.homePage.accessRegistrationPage();

		//driver.get("https://www.avoncomigo.avon.com.br/widget/avonwg2/#/login");
		//driver.manage().window().maximize();

		//Reports.log(LogStatus.INFO, "The website has started.", ScreenShot.capture(driver));

		//logintask.fillForm("65846980", "6965fi");

		//Reports.log(LogStatus.INFO, "Dados inseridos no formulario.", ScreenShot.capture(driver));

		try {
			verificationPoint.checkInvalidLoginMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterMethod
	 public void getResult(ITestResult result){
	 if(result.getStatus() == ITestResult.FAILURE){
	 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
	 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
	 }else if(result.getStatus() == ITestResult.SKIP){
	 logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	 }
	 extent.endTest(logger);
	
	}
	@After
	public void tearDown() {
		extent.flush();
		extent.close();
		this.driver.quit();
	}

}
