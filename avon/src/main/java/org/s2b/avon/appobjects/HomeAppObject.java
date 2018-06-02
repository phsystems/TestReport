package org.s2b.avon.appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeAppObject {
	private WebDriver driver;
	
	public HomeAppObject(WebDriver driver) {
		this.driver = driver;
	}
		
	public WebElement getLoginButton() {
		return this.driver.findElement(By.cssSelector("#links-bar > div > div > div > ul > li.pink.pull-right > a"));
	}
	public WebElement getRetailerNewButton() {
		return this.driver.findElement(By.cssSelector("#links-bar > div > div > div > ul > li.pink.pull-left > a"));
	}
	public WebElement getRetailerSearchButton() {
		return this.driver.findElement(By.cssSelector("#links-bar > div > div > div > ul > li:nth-child(3) > a"));
	}
	
}
