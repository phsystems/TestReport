package org.s2b.avon.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.s2b.avon.framework.Drives;
import org.s2b.avon.framework.Reports;
import org.s2b.avon.framework.ScreenShot;
import org.s2b.avon.tasks.HomeTask;
import org.s2b.avon.tasks.NewRetailerTask;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class NewtestCase {
	private WebDriver driver;
	private NewRetailerTask newRetailer;
	private HomeTask homePage; 
	
	@BeforeTest
	public void setUp() {
		Reports.startTest("New Retailer");
		this.driver = Drives.getFirefoxDriver();
		this.driver.get("http://www.avon.com.br/");
		this.driver.manage().window().maximize();
		homePage = new HomeTask(driver);
		newRetailer = new NewRetailerTask(driver);
	}
	@Test
	public void testMainTwo(){
		this.driver.get("http://www.avon.com.br/");
		this.driver.manage().window().maximize();
		
		try {
			Reports.log(LogStatus.INFO, "The website was loaded.", ScreenShot.capture(driver));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				this.homePage.accessRetailerNew();
				
		this.driver.get("https://www.br.avon.com/PRSuite/applyToBeRep.page?utm_source=brandsite&utm_medium=home-revendedores-avon&utm_term=seja-um-revendedor-link&utm_content=ir-para-a-pagina-de-revendedores&utm_campaign=seja-uma-revendedora");
		
		
		try {
			Reports.log(LogStatus.INFO, "The website was loaded.", ScreenShot.capture(driver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				this.newRetailer.newFillForm("Leticia", "Peretti", "22/12/1987", "01412499003", "Ph.sistemasinformacao@gmail.com", "Ph.sistemasinformacao@gmail.com", "51", "995793229", "51", "995793229", null, "96700000", "Madre Adelia", "64", null);
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
