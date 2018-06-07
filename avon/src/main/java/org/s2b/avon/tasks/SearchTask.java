package org.s2b.avon.tasks;

import org.openqa.selenium.WebDriver;
import org.s2b.avon.appobjects.SearchAppObject;

public class SearchTask {
	
	public static final String Search_Retailer_URL = "http://www.br.avon.com/PRSuite/locator.page";
	private WebDriver driver;
	private SearchAppObject search;
	
	public SearchTask(WebDriver driver){
		this.search = new SearchAppObject(driver);
	}
	public void fillCep(String CEP){
		search.getCEPTextField().sendKeys(CEP);
	}
	public void accessSearchPage(){
		search.getSearchButton().click();
	}
public void clickButton() {
		search.getcaptButton().click();
}
	
	
	public void accessBackPage(){
		search.getHomeBackButton().click();
	}
	public void navigateSearchToPage() {
		this.driver.get(Search_Retailer_URL);
	}
	

}
