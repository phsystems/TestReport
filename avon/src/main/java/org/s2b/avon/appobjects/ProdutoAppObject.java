package org.s2b.avon.appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProdutoAppObject {
	private WebDriver driver;
	
	public ProdutoAppObject(WebDriver driver){
		this.driver = driver;
	}
		
		public WebElement getSeachProduto(){
			return this.driver.findElement(By.id("SimpleSearchForm_SearchTerm"));
		}
		public WebElement getSeachProdutoButton() {
			return this.driver.findElement(By.cssSelector("#searchBox > a"));
		}
}
