package sw_demoga;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class Sw_demoga_1 {

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
	public void test_1a_1() {
		
		s.getTextByXpath("//*[@id='slides']/div[1]/div[1]/h2");
		s.clickByClass("buynow");
		s.sleep(3);
		s.getTitle();
		System.out.println(s.title + " contains " + s.text);
		Assert.assertTrue(s.title.contains(s.text));
	}
	
	
	@Test
	public void test_1a_2() {
		
		s.getTextByXpath("//*[@id='slides']/div[1]/div[1]/h2");
		s.clickByClass("featured_image");
		s.sleep(3);
		s.getTitle();
		System.out.println(s.title + " contains " + s.text);
		Assert.assertTrue(s.title.contains(s.text));
	}
	
	@Test
	public void test_1a_3() {
		
		s.getTextByXpath("//*[@id='slides']/div[1]/div[1]/h2");
		s.clickByXpath("//*[@title='More Info']");
		s.sleep(3);
		s.getTitle();
		System.out.println(s.title + " contains " + s.text);
		Assert.assertTrue(s.title.contains(s.text));
	}

	@Test
	public void test_1a_4() {
		
		s.getSlideInterval();
		String firstProduct = s.getTextByXpath("//*[@id='slides']/div[1]/div[1]/h2");
		System.out.println(s.text + " = " + firstProduct);		
		s.sleep(s.intervalValue+1);
		
		String secondProduct = s.getTextByXpath("//*[@id='slides']/div[1]/div[1]/h2");
		Assert.assertNotEquals(secondProduct,firstProduct);
		System.out.println(secondProduct + " != " + firstProduct);
		s.sleep(s.intervalValue+1);
		
		s.getTextByXpath("//*[@id='slides']/div[1]/div[1]/h2");
		Assert.assertNotEquals(s.text,firstProduct);
		Assert.assertNotEquals(s.text,secondProduct);
		System.out.println(s.text + " != " + secondProduct + " / " + firstProduct);
		s.sleep(s.intervalValue+1);
		
		s.getTextByXpath("//*[@id='slides']/div[1]/div[1]/h2");
		Assert.assertEquals(s.text,firstProduct);
		System.out.println(s.text + " = " + firstProduct);		
	}
	
	
	@Test
	public void test_1a_5() {
		
		String firstProduct = s.getTextByXpath("//*[@id='slides']/div[1]/div[1]/h2");
		
		s.clickByXpath("//*[@id='slide_menu']/a[2]");
		s.sleep(1L);
		String secondProduct = s.getTextByXpath("//*[@id='slides']/div[1]/div[1]/h2");
		Assert.assertNotEquals(secondProduct,firstProduct);
		System.out.println(secondProduct + " != " + firstProduct);
		
		s.clickByXpath("//*[@id='slide_menu']/a[3]");
		s.sleep(1L);
		s.getTextByXpath("//*[@id='slides']/div[1]/div[1]/h2");
		Assert.assertNotEquals(s.text,firstProduct);
		System.out.println(s.text + " != " + firstProduct);
		Assert.assertNotEquals(s.text,secondProduct);
		System.out.println(s.text + " != " + secondProduct);
		
		s.clickByXpath("//*[@id='slide_menu']/a[1]");
		s.sleep(1L);
		s.getTextByXpath("//*[@id='slides']/div[1]/div[1]/h2");
		System.out.println(s.text + " = " + firstProduct);		
		Assert.assertEquals(s.text,firstProduct);
	}
	
	//Osäker på denna, behöver bättre assertion
	@Test
	public void test_1b_1() {
	
		for(int i=1;i<5;i++){
		s.getTextByXpath("//*[@class='footer_featured']//ul/li["+ i + "]/a[3]");
		Assert.assertTrue(s.text.contains("More Details"));
		System.out.println("Latest blog post " + i + " contains " + s.text);
		}
	}

	@Test
	public void test_1b_2() {
		
		for(int i=1;i<5;i++){
		s.getTexteByXpathAndAttribute("//*[@class='footer_featured']//ul/li["+ i + "]/a[1]", "title");
		s.clickByXpath("//*[@class='footer_featured']//ul/li["+ i + "]/a[1]");
		s.sleep(1);
		s.getTitle();
		Assert.assertTrue(s.getTitle().contains(s.text));
		System.out.println(s.title + " contains " + s.text);
		s.goHome();
		s.sleep(3);
		}
	}
		
		
	@Test
	public void test_1b_3() {
			
		for(int i=1;i<5;i++){
		s.getTexteByXpathAndAttribute("//*[@class='footer_featured']//ul/li["+ i + "]/a[1]", "title");
		s.clickByXpath("//*[@class='footer_featured']//ul/li["+ i + "]/a[2]");
		s.sleep(1);
		s.getTitle();
		Assert.assertTrue(s.getTitle().contains(s.text));
		System.out.println(s.title + " contains " + s.text);
		s.goHome();
		s.sleep(3);
		}
	}
			
			
	
	@Test
	public void test_1b_4() {
		
		for(int i=1;i<5;i++){
			s.getTexteByXpathAndAttribute("//*[@class='footer_featured']//ul/li["+ i + "]/a[1]", "title");
			s.clickByXpath("//*[@class='footer_featured']//ul/li["+ i + "]/a[3]");
			s.sleep(1);
			s.getTitle();
			Assert.assertTrue(s.getTitle().contains(s.text));
			System.out.println(s.title + " contains " + s.text);
			s.goHome();
			s.sleep(3);
		}
	}
		


			
		
	

}
