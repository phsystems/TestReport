package org.s2b.avon.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drives {
	public static WebDriver getFirefoxDriver(){
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}
}