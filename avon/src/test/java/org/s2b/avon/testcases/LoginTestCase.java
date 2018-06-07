package org.s2b.avon.testcases;

import org.openqa.selenium.WebDriver;
import org.s2b.avon.appobjects.LoginAppObject;
import org.s2b.avon.framework.Drives;
import org.s2b.avon.framework.Reports;
import org.s2b.avon.framework.ScreenShot;
import org.s2b.avon.tasks.LoginTask;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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

	@BeforeClass
	public void setUp() {

		// Inicializa componentes
		this.driver = Drives.getFirefoxDriver();
		this.loginPage = new LoginTask(this.driver);
		this.loginAppObject = new LoginAppObject(this.driver);

		// Cria um novo report para este test case
		Reports.startTest("Login");

		// Inicializa em tela maximizada
		this.driver.manage().window().maximize();
	}

	@Test(dataProvider = "Authentication")
	public void loginTest(String user, String pwd) throws InterruptedException {

		// Navega para pagina de login
		this.loginPage.navigateToPage();
		
		// Preenche formulario de login
		this.loginPage.fillForm(user, pwd);

		Reports.log(LogStatus.PASS, "Inserção dados Usuario e Senha", ScreenShot.capture(driver));
		Thread.sleep(2000);
		// Submit dados de login
		this.loginPage.toRegister();
		Thread.sleep(5000);

 
		
		String expectedMessage = "LETICIA";
		String mensErro = "Esqueceu sua senha?";
		String userProfileSelector = this.loginAppObject.getProductTextfield().getText().toString();
		String mensErroPwd = this.loginAppObject.geterroMensTextField().getText().toString();
		System.out.println(expectedMessage);
		System.out.println(userProfileSelector);
		System.out.println(mensErroPwd);
		System.out.println(mensErro);
		
		
		

		if (userProfileSelector.equals(expectedMessage)){
			
			
			Reports.log(LogStatus.PASS, "Pagina Revendedor", ScreenShot.capture(driver));
			Thread.sleep(2000);

			System.out.println("Encontrou");

			Reports.log(LogStatus.PASS, "Encontrou", ScreenShot.capture(driver));

		 }
		if (mensErro.equals(mensErroPwd)){
			Reports.log(LogStatus.FAIL, "Não Encontrou", ScreenShot.capture(driver));
			
			System.out.println("Não encontrou");
		}


}

	@AfterClass
	public void tearDown() {
		Reports.close();
		this.driver.quit();
	}
}
