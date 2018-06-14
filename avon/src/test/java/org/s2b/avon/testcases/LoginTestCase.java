package org.s2b.avon.testcases;

import org.openqa.selenium.WebDriver;
import org.s2b.avon.appobjects.LoginAppObject;
import org.s2b.avon.framework.Drives;
import org.s2b.avon.framework.Reports;
import org.s2b.avon.framework.ScreenShot;
import org.s2b.avon.tasks.LoginTask;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class LoginTestCase {

	@DataProvider(name = "Authentication")

	public static Object[][] credentials() {

		return new Object[][] { { "65846980", "6965FiFi" } };
	}

	private WebDriver driver;
	private LoginTask loginPage;
	private LoginAppObject loginAppObject;

	@BeforeTest
	public void setUp() {
		this.driver = Drives.getFirefoxDriver();
		this.loginPage = new LoginTask(this.driver);
		this.loginAppObject = new LoginAppObject(this.driver);

		Reports.startTest("Login");
		this.driver.manage().window().maximize();
	}

	@Test(dataProvider = "Authentication")
	public void loginTest(String user, String pwd) throws InterruptedException {

		this.loginPage.navigateToPage();

		this.loginPage.fillForm(user, pwd);

		Reports.log(LogStatus.INFO, "Inserção dados Usuario e Senha", ScreenShot.capture(driver));
		Thread.sleep(5000);

		this.loginPage.toRegister();
		Thread.sleep(5000);

		
		String mensErro = "ÁREA EXCLUSIVA";
		String mensErroPwd = this.loginAppObject.getErroMensTextField().getText().toString();
		Thread.sleep(20000);
		System.out.println(mensErroPwd);
		String expectedMessage = "MINHA CONTA";
		String userProfileSelector = this.loginAppObject.getProductTextfield().getText().toString();
		Thread.sleep(5000);
		System.out.println(mensErroPwd + userProfileSelector);

		if (userProfileSelector.equals(expectedMessage)) {
			Thread.sleep(2000);
			Reports.log(LogStatus.PASS, "Pagina Revendedor", ScreenShot.capture(driver));
			
		} 
		/*By userProfileSelector = By.cssSelector("#btn-profile > span.helloName");
		  new WebDriverWait(driver, 10)
			.until(ExpectedConditions.visibilityOfElementLocated(userProfileSelector));
		
		  assertEquals("LETICIA", driver.findElement(userProfileSelector).getText());*/
}

	@Test
	public void loginTestError() throws InterruptedException {

		this.loginPage.navigateToPage();

		this.loginPage.fillForm("586478", "5698FiFa");
		Reports.log(LogStatus.INFO, "Inserção dados Usuario e Senha", ScreenShot.capture(driver));
		Thread.sleep(5000);

		this.loginPage.toRegister();
		Thread.sleep(10000);

		String mensErro = "ÁREA EXCLUSIVA";
		String mensErroPwd = this.loginAppObject.getErroMensTextField().getText().toString();
		Thread.sleep(20000);
		System.out.println(mensErroPwd);

		if (mensErro.equals(mensErroPwd)) {

			Reports.log(LogStatus.PASS, "Login invalido", ScreenShot.capture(driver));
			Thread.sleep(2000);

		} else {
			Reports.log(LogStatus.FAIL, "Erro ", ScreenShot.capture(driver));
			System.out.println("Erro Teste");
		}
	}

	@AfterClass
	public void tearDown() {
		Reports.close();
		this.driver.quit();
	}
}
