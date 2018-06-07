package org.s2b.avon.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.s2b.avon.appobjects.LoginAppObject;
import org.s2b.avon.framework.Drives;
import org.s2b.avon.framework.Reports;
import org.s2b.avon.framework.ScreenShot;
import org.s2b.avon.tasks.LoginTask;
import org.s2b.avon.verification.VerificationHome;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class LoginTestCase {

	@DataProvider(name = "Authentication")

	public static Object[][] credentials() {

		return new Object[][] { { "54859635", "5847ho"}, { "65846980", "6965gi"}, { "89321457", "6965fi" },
				{ "65846980", "6569fi"} };

	}

	private WebDriver driver;
	private LoginTask loginPage;
	@BeforeClass
	public void setUp() {

		// Inicializa componentes
		this.driver = Drives.getFirefoxDriver();
		this.loginPage = new LoginTask(this.driver);

		// Cria um novo report para este test case
		Reports.startTest("Login");

		// Inicializa em tela maximizada
		this.driver.manage().window().maximize();
	}

	@Test(dataProvider = "Authentication")
	public void loginTest(String user, String pwd) throws InterruptedException {

		// Navega para pagina de login 
		this.loginPage.navigateToPage();

		Reports.log(LogStatus.PASS, "Pagina de Login", ScreenShot.capture(driver));

		// Preenche formulario de login
		this.loginPage.fillForm(user, pwd);

		Reports.log(LogStatus.PASS, "Inserção dados Usuario e Senha", ScreenShot.capture(driver));

		// Submit dados de login
		this.loginPage.toRegister();
		Thread.sleep(2000);
		
		final String expectedMessage = "Bem-vindo à Avon Campanha 10";
		By userProfileSelector = By.cssSelector("#btn-profile > span.helloName");
		new WebDriverWait(driver, 10)
			.until(ExpectedConditions.visibilityOfElementLocated(userProfileSelector));

		// Verificacao 
		assertEquals(expectedMessage, driver.findElement(userProfileSelector).getText());

		final String expectedMessage = "Bem-vindo à Avon Campanha 10";
		if (this.driver.getTitle().contains(expectedMessage)) {
			By userProfileSelector = By.cssSelector("#btn-profile > span.helloName");
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(userProfileSelector));

			assertEquals("LETICIA", driver.findElement(userProfileSelector).getText());

			Reports.log(LogStatus.PASS, "Pagina Revendedor", ScreenShot.capture(driver));
			Thread.sleep(2000);
			System.out.println("Encontrou");

			Reports.log(LogStatus.PASS, "Encontrou", ScreenShot.capture(driver));

		} else {
			Reports.log(LogStatus.FAIL, "Não Encontrou", ScreenShot.capture(driver));
		}
		System.out.println("Não encontrou"); 
	 
	}

	@AfterClass
	public void tearDown() {
		Reports.close();
		this.driver.quit();
	}
}
