package kp;

public class myJUnit2 extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception{
		System.out.println("Before TC Running");
		selenium = new DefaultSelenium("localhost", 4444, "*chrome","http://www.weather.com/");
		selenium.start();
	}
	
	@Test
	public void testUntitled1() throws Exception{
		System.out.println("TC1 Running");
		selenium.open("/");
		selenium.type("id=typeaheadBox", "91367");
		selenium.click("id=twc-weather-search-submit-id");
		//selenium.waitForPageToLoad("30000");
		Thread.sleep(8000);
		verifyTrue(selenium.isTextPresent("Woodland Hills, CA(91367)Weather"));
		if(vResult){
			System.out.println("Pass1");
		}else{
			System.out.println("Fail1");
			fail("JUnit Result1: Fail");
		}
		System.out.println("TC1 Run complete");
	}
	@Test
	public void testUntitled2() throws Exception{
		System.out.println("TC2 Running");
		selenium.open("http://www.weather.com/");
		selenium.type("id=typeaheadBox", "91367");
		selenium.click("id=twc-weather-search-submit-id");
		
		
	}

}
