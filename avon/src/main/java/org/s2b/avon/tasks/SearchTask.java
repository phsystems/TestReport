package org.s2b.avon.tasks;

import org.openqa.selenium.WebDriver;
import org.s2b.avon.appobjects.SearchAppObject;

public class SearchTask {
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
	public void accessBackPage(){
		search.getHomeBackButton().click();
	}
	

}
