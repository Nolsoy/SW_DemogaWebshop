package sw_demoga;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetupDriver {

	protected static WebDriver driver;
	protected String url,title,text;
	protected long intervalValue;
	protected int itemValue;
	
	
	public SetupDriver() {
		driver = new FirefoxDriver();
	}
	
	
	
	public static void killDriver() {
		
		if(driver != null){

				try {
					TimeUnit.SECONDS.sleep(5L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	

				driver.close();
			
		}
	}
}
