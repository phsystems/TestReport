package org.s2b.avon.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.s2b.avon.appobjects.*;

public class LoginTask {
private LoginAppObject login;
	
	public LoginTask(WebDriver driver){
		this.login = new LoginAppObject(driver);
	}
	public void fillForm(String userName, String password){
				
		login.getUserNameTextField().sendKeys(userName);
		login.getPasswordTextField().sendKeys(password);
		}
	public void toRegister(){
		login.getRegisterButton().click();
	}

}
