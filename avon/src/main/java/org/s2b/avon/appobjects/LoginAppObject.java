package org.s2b.avon.appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginAppObject {

	private WebDriver driver;

	public LoginAppObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUserNameTextField() {
		return driver.findElement(By.name("userName"));
	}

	public WebElement getPasswordTextField() {
		return driver.findElement(By.id("pwd"));
	}

	public WebElement getRegisterButton() { // #btn-profile > span.helloName
		return driver.findElement(By.id("loginBtn"));
	}

	public WebElement getProductTextfield() {
		return driver.findElement(By.cssSelector("#wrapperFooter > div.linhaFooter1 > div.boxMinhaContaFooter > h3")); 
	}
	public WebElement getErroMensTextField() {
		return driver.findElement(By.cssSelector(".avonwg-login-heading"));
	}
}
