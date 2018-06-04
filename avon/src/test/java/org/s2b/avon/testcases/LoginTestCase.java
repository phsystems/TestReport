package org.s2b.avon.testcases;

import static org.testng.Assert.assertEquals;

import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.s2b.avon.framework.Drives;
import org.s2b.avon.framework.Reports;
import org.s2b.avon.framework.ScreenShot;
import org.s2b.avon.tasks.LoginTask;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTestCase {

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

	@Test
	public void loginTest() {

		// Navega para pagina de login
		this.loginPage.navigateToPage();

		Reports.log(LogStatus.INFO, "Pagina de Login", ScreenShot.capture(driver));

		// Preenche formulario de login
		this.loginPage.fillForm("65846980", "6965fi");

		Reports.log(LogStatus.INFO, "Inserção dados Usuario e Senha", ScreenShot.capture(driver));

		// Submit dados de login
		this.loginPage.toRegister();

		// Aguarda login finalizar e a pagina de profile ser aparecer
		By userProfileSelector = By.cssSelector("#btn-profile > span.helloName");
		new WebDriverWait(driver, 10)
			.until(ExpectedConditions.visibilityOfElementLocated(userProfileSelector));

		// Verificacao 
		assertEquals("LETICIA", driver.findElement(userProfileSelector).getText());
	}

	@AfterClass
	public void tearDown() {
		Reports.close();
		this.driver.quit();
	}
}
