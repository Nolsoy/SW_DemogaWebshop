package sw_demoga;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Sw_demoga_4 {

private static StartPage s;
	
	@BeforeClass
	public static void beforeClass() {
		
		s = new StartPage("http://store.demoqa.com/");
	}
	
	@Before
	public void before() {
		
		s.goHome();
	}
	

	
	
	@AfterClass
	public static void afterClass(){
		
		SetupDriver.killDriver();
	}


	@Test
	public void test_4(){
	
		String prodName= "iPhone 5";
		s.sendKeysByClassAndSubmit("search", prodName);
		s.sleep(3);
		s.getTitle();
		Assert.assertTrue(s.title.contains(prodName));
		Assert.assertTrue(s.title.contains("Search Results"));
		s.getTextByClass("prodtitle");
		System.out.println(s.text);
		Assert.assertEquals(prodName, s.text);
		
		
	
	}
	

}
