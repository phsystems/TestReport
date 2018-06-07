package org.s2b.avon.appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchAppObject {
	private WebDriver driver;
	
	public SearchAppObject(WebDriver driver){
		this.driver = driver;
	}
	public WebElement getCEPTextField() {
		return this.driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td > div > form > table > tbody > tr > td > table > tbody > tr:nth-child(5) > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(4) > td.body > input"));
	}
	public WebElement getSearchButton() {
		return this.driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td > div > form > table > tbody > tr > td > table > tbody > tr:nth-child(5) > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td > a > img"));
	}	
	public WebElement getcaptButton() {
		return this.driver.findElement(By.cssSelector("#recaptcha-anchor > div.recaptcha-checkbox-checkmark"));
	}

	public WebElement getHomeBackButton() {
		return this.driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(1) > td > div:nth-child(1) > form > table:nth-child(1) > tbody > tr:nth-child(2) > td:nth-child(3) > table > tbody > tr:nth-child(1) > td > table > tbody > tr > td:nth-child(1) > a > font"));
	}

}
