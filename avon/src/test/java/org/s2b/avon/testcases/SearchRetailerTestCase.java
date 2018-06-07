package org.s2b.avon.testcases;

import org.openqa.selenium.WebDriver;
import org.s2b.avon.framework.Drives;
import org.s2b.avon.framework.Reports;
import org.s2b.avon.framework.ScreenShot;
import org.s2b.avon.tasks.SearchTask;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class SearchRetailerTestCase {
	
	private WebDriver driver;
	private SearchTask searchTask;
	
	
	@BeforeClass
	public void setUp() {
		
		this.driver = Drives.getFirefoxDriver();
		this.searchTask = new SearchTask (this.driver);
		Reports.startTest("Pesquisa Revendedor");
		
		
	}	
	@Test 
	public void loginTest() throws InterruptedException {
		
		this.driver.get("http://www.br.avon.com/PRSuite/locator.page");
		this.driver.manage().window().maximize();
		Thread.sleep(2000);
		Reports.log(LogStatus.PASS, "Pagina de Pesquisa de Revendedor", ScreenShot.capture(driver));
		
		this.searchTask.fillCep("96700000");
		Thread.sleep(3000);
		Reports.log(LogStatus.INFO, "CEP Inserido", ScreenShot.capture(driver));
		
		Thread.sleep(2000);
		this.searchTask.accessSearchPage();
		
		
	}
	
	@AfterClass
	public void tearDown() {
		Reports.close();
		this.driver.quit();
	}

	

}
