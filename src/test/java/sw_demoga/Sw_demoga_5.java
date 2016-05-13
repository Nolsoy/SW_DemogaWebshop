package sw_demoga;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Sw_demoga_5 {

private static StartPage s;
	
	@BeforeClass
	public static void beforeClass() {
		
		s = new StartPage("http://store.demoqa.com/products-page/product-category/");
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
	public void test_5_a(){
	
		for(int i=3;i<6;i++){
			String prodName = s.getTextByXpath("//*[@id='default_products_page_container']/div[" + i + "]/div[2]/h2/a");
			System.out.println(prodName);
			s.clickByXpath("//*[@id='default_products_page_container']/div[" + i + "]/div[2]/form/div[2]/div[1]/span/input");
			s.sleep(6);
			s.getTextByID("fancy_notification_content");
			System.out.println(s.text);
			Assert.assertTrue(s.text.contains(prodName));
			s.goHome();
		}
	}
	
	
	@Test
	public void test_5_b(){
	
		for(int i=3;i<6;i++){
			String prodName = s.getTextByXpath("//*[@id='default_products_page_container']/div[" + i + "]/div[2]/h2/a");
			System.out.println(prodName);
			s.clickByXpath("//*[@id='default_products_page_container']/div[" + i + "]/div[2]/form/div[2]/div[1]/span/input");
			s.sleep(4);
			s.clickByClass("go_to_checkout");
			s.sleep(4);
			s.getTitle();
			Assert.assertTrue(s.title.contains("Checkout"));
			s.getTextByXpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr[" + String.valueOf(i-1) + "]/td[2]/a");
			Assert.assertTrue(s.text.contains(prodName));
			s.goHome();
		}
	}
	
	
	@Test
	public void test_5_c(){
	
		for(int i=3;i<6;i++){
			String initialPageTitle = s.getTitle();
			int inititalItemValue = s.getItemValue();
			s.clickByXpath("//*[@id='default_products_page_container']/div[" + i + "]/div[2]/form/div[2]/div[1]/span/input");
			s.sleep(3);
			s.clickByClass("continue_shopping");
			s.sleep(4);
			s.getTitle();
			Assert.assertEquals(initialPageTitle, s.title);
			s.getItemValue();
			inititalItemValue++;
			Assert.assertEquals(s.itemValue, inititalItemValue);
		}
	}
	

}
