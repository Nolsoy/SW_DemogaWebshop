package sw_demoga;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class StartPage extends SetupDriver {


	public StartPage(String url) {
		
		this.url = url;
		driver.get(url);

	}
	
public void goHome(){
	
		driver.get(url);
}
	

public void sleep(long time){
	try {
		TimeUnit.SECONDS.sleep(time);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}


public String getTitle(){
	this.title = driver.getTitle();
	return this.title;
}


public String getTextByXpath(String xpath){
	this.text = driver.findElement(By.xpath(xpath)).getText();
	return this.text;
}

public String getTextByID(String ID){
	this.text = driver.findElement(By.id(ID)).getText();
	return this.text;
}

public String getTextByClass(String className){
	this.text = driver.findElement(By.className(className)).getText();
	return this.text;
}

public String getTexteByXpathAndAttribute(String xpath, String attribute){
	this.text = driver.findElement(By.xpath(xpath)).getAttribute(attribute);
	return this.text;
}


public void clickByClass(String className) {
	
	driver.findElement(By.className(className)).click();
}


public void clickByLinkText(String LinkText) {
	
	driver.findElement(By.linkText(LinkText)).click();
}

public void clickByXpath(String xpath){
	
	driver.findElement(By.xpath(xpath)).click();
}

public void clickByID (String ID){
	
	driver.findElement(By.id(ID)).click();
}

public void sendKeysByClassAndSubmit (String className, String keyToSend){
	driver.findElement(By.className(className)).sendKeys(keyToSend + Keys.RETURN);
}

public void SubmitByClass (String className){
	driver.findElement(By.className(className)).sendKeys(Keys.RETURN);
}


public int getItemValue(){
	this.itemValue = Integer.valueOf(driver.findElement(By.className("count")).getText());
	return this.itemValue;
}

public long getSlideInterval(){
	
	this.intervalValue = Long.valueOf(driver.findElement(By.className("homepage_slider_interval")).getAttribute("value"));
	return intervalValue;
}

public void mouseOverByID(String ID, int time){
	
	driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	WebElement ele = driver.findElement(By.id(ID));
	Actions action = new Actions(driver);
	action.moveToElement(ele).build().perform();
	
}

}
