package org.s2b.avon.testcases;

import org.openqa.selenium.WebDriver;
import org.s2b.avon.framework.Drives;
import org.s2b.avon.framework.Reports;
import org.s2b.avon.framework.ScreenShot;
import org.s2b.avon.tasks.NewRetailerTask;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class NewtestCase {
	private WebDriver driver;
	private NewRetailerTask newRetailer;

	@BeforeTest
	public void setUp() {

		this.driver = Drives.getFirefoxDriver();
		this.newRetailer = new NewRetailerTask(this.driver);

		Reports.startTest("New Retailer");
		this.driver.manage().window().maximize();
	}

	@Test
	public void testMainTwo() throws InterruptedException {
		this.newRetailer.newRetailerToPage();

		Thread.sleep(2000);
		Reports.log(LogStatus.INFO, "The website was loaded.", ScreenShot.capture(driver));

		this.newRetailer.newFillForm("Leticia", "Peretti", "22/12/1987", "01412499003",
				"Ph.sistemasinformacao@gmail.com", "Phsistemasinformacao@gmail.com", "51", "995793229", "51",
				"995793229", null, "96700000", "Madre Adelia", "64", null);
		Thread.sleep(2000);
	}

	@AfterClass
	public void tearDown() {
		Reports.close();
		this.driver.quit();
	}

}
