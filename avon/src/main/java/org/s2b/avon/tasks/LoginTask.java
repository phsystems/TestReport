package org.s2b.avon.tasks;

import org.openqa.selenium.WebDriver;
import org.s2b.avon.appobjects.LoginAppObject;

public class LoginTask {
	public static final String LOGIN_URL = "https://www.avoncomigo.avon.com.br/widget/avonwg2/#/login";
	private LoginAppObject login;
	private WebDriver driver;

	public LoginTask(WebDriver driver) {
		this.login = new LoginAppObject(driver);
		this.driver = driver;
	}
 
	public void fillForm(String userName, String password) {
		login.getUserNameTextField().click();
		login.getUserNameTextField().clear();
		login.getUserNameTextField().sendKeys(userName);
		login.getPasswordTextField().click();
		login.getPasswordTextField().clear();
		login.getPasswordTextField().sendKeys(password);
	} 

	public void toRegister() {
		login.getRegisterButton().click();
	}

	public void navigateToPage() {
		this.driver.get(LOGIN_URL);
	}

}
