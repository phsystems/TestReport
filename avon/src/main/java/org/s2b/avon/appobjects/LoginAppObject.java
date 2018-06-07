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

	public WebElement getRegisterButton() {
		return driver.findElement(By.id("loginBtn"));
	}
	public WebElement getProductTextfield() {
		return driver.findElement(By.cssSelector("#btn-profile > span.helloName"));
	}
	public WebElement geterroMensTextField() {
		return driver.findElement(By.cssSelector(".avowng-forgotpwd"));
	}
}
