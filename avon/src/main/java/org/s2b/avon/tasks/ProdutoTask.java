package org.s2b.avon.tasks;

import org.openqa.selenium.WebDriver;
import org.s2b.avon.appobjects.ProdutoAppObject;

public class ProdutoTask {
	private ProdutoAppObject search;
	
	public ProdutoTask(WebDriver driver){
		this.search = new ProdutoAppObject(driver);
	}
	public void fillProduto(String codigo){
		search.getSeachProduto().sendKeys(codigo);
	}
	public void searchProduto(){
		search.getSeachProdutoButton().click();
	}

}
