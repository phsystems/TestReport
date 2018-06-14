package org.s2b.avon.testcases;

import org.openqa.selenium.WebDriver;
import org.s2b.avon.appobjects.ProdutoAppObject;
import org.s2b.avon.framework.Drives;
import org.s2b.avon.framework.Reports;
import org.s2b.avon.framework.ScreenShot;
import org.s2b.avon.tasks.LoginTask;
import org.s2b.avon.tasks.ProdutoTask;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

public class ProdutoTesteCase {	 
	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
		return new Object[][] { { "786641", "Presente Encanto Seducao" }};
	}
	private WebDriver driver;
	private ProdutoTask produtotask;
	private LoginTask login;
	private ProdutoAppObject produtoAppObject;

	@BeforeClass
	public void start() throws InterruptedException {
		this.driver = Drives.getFirefoxDriver();
		this.login = new LoginTask(this.driver);
		this.login.navigateToPage();
		this.login.fillForm("65846980", "6965FiFi");
		this.login.toRegister();
		Thread.sleep(5000);
		this.produtotask = new ProdutoTask(this.driver);
		this.produtoAppObject = new ProdutoAppObject(this.driver);
		Reports.startTest("Codigo do Produto");	
	}

    @Test(dataProvider = "Authentication")
	public void testOne(String codigo, String produto) throws InterruptedException {  	

		this.produtotask.navigateToRetailerPage();
		this.produtotask.fillProduto(codigo);
		Thread.sleep(3000);
		Reports.log(LogStatus.INFO, "Inserção do Codigo", ScreenShot.capture(driver));
		this.produtotask.searchProduto();
		Thread.sleep(10000);
		
		String expectedMessage = this.produtoAppObject.getFillTextProd().getText().toString();
		System.out.println(expectedMessage);
		if (produto.equals(expectedMessage)) {
			Reports.log(LogStatus.PASS, "Produto Correto", ScreenShot.capture(driver));
			System.out.println("Produto Correto");
			
		}
	} 
    @Test
	public void testTwo() throws InterruptedException {  	
    	
    	String produto = "CT Batom Efeito Gloss Roxo Lacrador";

		this.produtotask.navigateToRetailerPage();
		this.produtotask.fillProduto("527614");
		Thread.sleep(3000);
		Reports.log(LogStatus.INFO, "Inserção do Codigo", ScreenShot.capture(driver));
		this.produtotask.searchProduto();
		Thread.sleep(10000);
		String expectedMessage = this.produtoAppObject.getFillTextProd().getText().toString();
		System.out.println(expectedMessage);
		System.out.println(produto);
		if (produto !=expectedMessage){
			Reports.log(LogStatus.PASS, "Produto Incoreto", ScreenShot.capture(driver));
		}
	}

	@AfterClass
	public void tearDown() {
	Reports.close();
 	this.driver.quit();

	}

}
