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
		return this.driver.findElement(By.xpath("html#ng-app.js.flexbox.flexboxlegacy.canvas.canvastext.webgl.no-touch.geolocation.postmessage.no-websqldatabase.indexeddb.hashchange.history.draganddrop.websockets.rgba.hsla.multiplebgs.backgroundsize.borderimage.borderradius.boxshadow.textshadow.opacity.cssanimations.csscolumns.cssgradients.no-cssreflections.csstransforms.csstransforms3d.csstransitions.fontface.generatedcontent.video.audio.localstorage.sessionstorage.webworkers.applicationcache.svg.inlinesvg.smil.svgclippaths body header#dd-l-header.dd-l-header.dd-l-grid div.dd-l-row div.dd-l-col.dd-m-hide-mobile.dd-m-text-right a"));
	}
	public WebElement getRetailerNewButton() {
		return this.driver.findElement(By.cssSelector("#links-bar > div > div > div > ul > li.pink.pull-left > a"));
	}
	public WebElement getRetailerSearchButton() {
		return this.driver.findElement(By.cssSelector("#links-bar > div > div > div > ul > li:nth-child(3) > a"));
	}
	
}
