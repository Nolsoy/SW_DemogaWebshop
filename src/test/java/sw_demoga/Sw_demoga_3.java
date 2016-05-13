package sw_demoga;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Sw_demoga_3 {

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
	public void test_3(){
	
		s.mouseOverByID("menu-item-33", 20);
		s.getTexteByXpathAndAttribute("//*[@class='sub-menu']", "style");
		Assert.assertTrue(s.text.contains("block"));
		System.out.println(s.text);
		for(int i=4;i<10;i++){

			s.getTextByID("menu-item-3" + i);
			System.out.println(s.text);
			if(i==4){
				Assert.assertEquals("Accessories", s.text);

			}
			else if(i==5){
				Assert.assertEquals("iMacs", s.text);
			}
			else if(i==6){
				Assert.assertEquals("iPads", s.text);
			}
			else if(i==7){
				Assert.assertEquals("iPhones", s.text);
			}
			else if(i==8){
				Assert.assertEquals("iPods", s.text);
			}
			else if(i==9){
				Assert.assertEquals("MacBooks", s.text);
			}
			else{System.out.println("Missing links");}	
			
			s.clickByID("menu-item-3" + i);
			s.sleep(4);
			s.getTitle();
			System.out.println(s.title);
			Assert.assertTrue(s.title.contains(s.text));
			s.mouseOverByID("menu-item-33", 20);
		}
	
	}
	

}
