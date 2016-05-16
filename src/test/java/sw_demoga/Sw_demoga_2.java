package sw_demoga;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Sw_demoga_2 {

private static StartPage s;
	
	@BeforeClass
	public static void beforeClass() {
		
		s = new StartPage("http://store.demoqa.com/products-page/product-category/n/");
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
	public void test_2a(){
		
		s.getTextByXpath("//*[@id='single_product_page_container']/div[1]/div[2]/h1");
		System.out.println(s.text);
		s.getTitle();
		Assert.assertEquals(s.text + " | ONLINE STORE", s.title);
		System.out.println("Title is ok!");
		
		s.getTextByXpath("//*[@id='single_product_page_container']/div[1]/div[2]/div[1]/p");		
		System.out.println(s.text);
		Assert.assertTrue(s.text.contains("Splashing Pixels"));
		System.out.println("Product description is ok!");
		
		s.getTextByXpath("//*[@id='single_product_page_container']/div[1]/div[2]/form/div[1]/p/span");		
		System.out.println(s.text);
		Assert.assertTrue(s.text.contains("$"));
		System.out.println("Price is ok!");
	}
	
	@Test
	public void test_2b(){
	
		int inititalItemValue = s.getItemValue();
		s.clickByClass("wpsc_buy_button");
		s.sleep(7);
		s.getItemValue();
		Assert.assertEquals(inititalItemValue+1, s.itemValue);
		System.out.println(inititalItemValue+1 + " = " + s.itemValue);
	
	}
	
	/*Hoppar över 2c.i & 2c.ii - kan bara rösta en gång, därefter visas inte "Thanks for rating"-meddelandet längre.
	
	@Test
	public void test_2c(){
	
			s.clickByXpath("//*[@id='single_product_page_container']/div[1]/div[2]/div[2]/span/div[3]/a");
			s.sleep(8);
			s.getTextByClass("message");
			System.out.println("Meddelande = " + s.text);
			Assert.assertEquals("Sorry, you already rated!", s.text);
		
	
	}*/
	

}
