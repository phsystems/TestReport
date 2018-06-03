package org.s2b.avon.testcases;

import org.openqa.selenium.WebDriver;
import org.s2b.avon.framework.Drives;
import org.s2b.avon.framework.Reports;
import org.s2b.avon.tasks.LoginTask;
import org.s2b.avon.tasks.ProdutoTask;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ProdutoTesteCase {
	private WebDriver driver;
	private LoginTask logintask;
	private ProdutoTask produto;
	
	

	@BeforeTest
	public void start() {
		Reports.startTest("Codigo do Produto");
		this.driver = Drives.getFirefoxDriver();
		driver.get("https://www.avoncomigo.avon.com.br/widget/avonwg2/#/login");
		this.logintask.fillForm("65846980", "6965fi");
		this.logintask.toRegister();
	}

	@Test
	public void passTest() {
		this.produto.fillProduto("452587");
		this.produto.searchProduto();
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
