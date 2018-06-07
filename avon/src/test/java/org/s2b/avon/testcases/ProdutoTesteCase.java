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

		return new Object[][] { { "786641", "Presente Encanto Seducao" },
				 { "400430", "Renew Reversalist Dia Creme Anti-Idade FPS 25 50 g" },
				 { "786641", "Presente Encanto Seducao" },
				 { "786480", "Presente Encanto Surpreendente" }, 
				 { "527609","CT Batom Efeito Gloss Coral Diva" },
				 { "527614", "CT Batom Efeito Gloss Nude Do Poder" },
				 { " 527586", "CT Batom Efeito Gloss Rosa Carão" },
				 { " 527620", "CT Batom Efeito Gloss Vermelho Magia" }, 
				 { " 527635", "CT Batom Efeito Gloss Roxo Lacrador" }, 
				 { "786433", "Presente Color Trend Amora" }, 
				 { "786412", "Presente Color Trend Melancia" }, 
				 { "527079", "Clearskin Combate Espinhas - Loção Tonica Facial Adstringente 200ml" },
				 { " 527042", "Clearskin Combate Espinhas Gel Facial Secativo 15g" }, 
				 { " 440909", "Renew Ultimate Multiação Dia Creme Facial Antirrugas FPS 25 50 g" },
				 { "524313", "Color Trend Pó Facial Compacto Porcelana" },
				 { "524340", "Color Trend Pó Facial Compacto Bege Médio" }, 
				 { "524360", "Color Trend Pó Facial Compacto FPS 10 Café Médio 7g" }, 
				 { "524355", "Color Trend Pó Facial Compacto FPS 10 Bronze 7g" },
				 { "524446", "Color Trend Pó Facial Compacto FPS 10 Tropicana Médio 7g"} };

	}

	private WebDriver driver;
	private ProdutoTask produtotask;
	private LoginTask login;
	private ProdutoAppObject produtoAppObject;

	@BeforeClass
	public void start() {
		this.driver = Drives.getFirefoxDriver();
		this.login = new LoginTask(this.driver);

		this.login.navigateToPage();

		this.login.fillForm("65846980", "6965fi");

		this.login.toRegister();

		this.produtotask = new ProdutoTask(this.driver);
		this.produtoAppObject = new ProdutoAppObject(this.driver);
		Reports.startTest("Codigo do Produto");

		this.driver.manage().window().maximize();
	}

	@Test(dataProvider = "Authentication")
	public void testCodigoProduto(String codigo, String produto) throws InterruptedException {

		this.produtotask.navigateToRetailerPage();

		this.produtotask.fillProduto(codigo);
		Thread.sleep(1000);
 
		this.produtotask.searchProduto();

		Thread.sleep(8000);	

		String expectedMessage = this.produtoAppObject.getFillTextProd().getText().toString();

		if (produto.equals(expectedMessage))  {
			Reports.log(LogStatus.PASS, "Produto Correto", ScreenShot.capture(driver));

			System.out.println("Produto Correto");

		}else {
			Reports.log(LogStatus.FAIL, "Produto Incorreto", ScreenShot.capture(driver));

			System.out.println("Produto Incorreto");
		}

	}

	@AfterClass
	public void tearDown() {
		Reports.close();
		this.driver.quit();
	}

}
