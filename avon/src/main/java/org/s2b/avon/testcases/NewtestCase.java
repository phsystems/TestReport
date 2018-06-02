package org.s2b.avon.testcases;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.s2b.avon.framework.Drives;
import org.s2b.avon.framework.Reports;
import org.s2b.avon.framework.ScreenShot;
import org.s2b.avon.tasks.HomeTask;
import org.s2b.avon.tasks.NewRetailerTask;
import com.relevantcodes.extentreports.LogStatus;

public class NewtestCase {
	private WebDriver driver;
	private NewRetailerTask newRetailer;
	private HomeTask homePage; 
	
	@Before
	public void setUp() {
		Reports.startTest("New Retailer");
		this.driver = Drives.getFirefoxDriver();
		this.driver.get("http://www.avon.com.br/");
		this.driver.manage().window().maximize();
		homePage = new HomeTask(driver);
		newRetailer = new NewRetailerTask(driver);
	}
	@Test
	public void testMainTwo() throws IOException {
		//this.driver.get("http://www.avon.com.br/");
		//this.driver.manage().window().maximize();
		//Report.log(Status.INFO, "The website was loaded.", ScreenShot.capture(driver));
				//this.homePage.accessRetailerNew();
				
		this.driver.get("https://www.br.avon.com/PRSuite/applyToBeRep.page?utm_source=brandsite&utm_medium=home-revendedores-avon&utm_term=seja-um-revendedor-link&utm_content=ir-para-a-pagina-de-revendedores&utm_campaign=seja-uma-revendedora");
		//this.driver.manage().window().maximize();	
		
		Reports.log(LogStatus.INFO, "The website was loaded.", ScreenShot.capture(driver));
		
				this.newRetailer.newFillForm("Leticia", "Peretti", "22/12/1987", "01412499003", "Ph.sistemasinformacao@gmail.com", "Ph.sistemasinformacao@gmail.com", "51", "995793229", "51", "995793229", null, "96700000", "Madre Adelia", "64", null);
	}
	@After
	public void tearDown() {
		this.driver.quit();
	}
	

}
