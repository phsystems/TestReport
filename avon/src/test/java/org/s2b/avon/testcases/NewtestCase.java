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

		Reports.startTest("Novo Revendedor");
		this.driver.manage().window().maximize();
	}

	@Test
	public void testNewRetailer() throws InterruptedException {
		this.newRetailer.newRetailerToPage();

		Thread.sleep(2000);
		Reports.log(LogStatus.INFO, "Pagina cadastro novo vendedor", ScreenShot.capture(driver));
		this.newRetailer.fiillCep("96700000");
		Thread.sleep(10000);
		this.newRetailer.newFillForm("Leticia", "Peretti", "22/12/1987", "01412499003",
				"Ph.sistemasinformacao@gmail.com", "Phsistemasinformacao@gmail.com", "51", "995793229", "51",
				"995793229","Madre Adelia", "64", "Santo Angelo");
		Thread.sleep(4000);
		Reports.log(LogStatus.INFO, "Pagina cadastro novo vendedor preenchido", ScreenShot.capture(driver));
		Thread.sleep(5000);
	}

	@AfterClass
	public void tearDown() {
		Reports.close();
		this.driver.quit();
	}

}
