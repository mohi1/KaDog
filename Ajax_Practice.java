package kp;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ajax_Practice {
	private WebDriver driver;
	private String baseUrl="http://www.kayak.com/";
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	@Test
	public void testUntitled() throws Exception{
		driver.get(baseUrl);
		driver.findElement(By.id("wherebox")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("wherebox")).sendKeys("New O");
		Thread.sleep(1000);
		String xP1 = "//html/body/div[9]/ul/li[";
		String xP2="]";
		String xP3;
		
		int i = 1;
		xP3 = xP1 + i + xP2;
		try {
			while(driver.findElement(By.xpath(xP3)).isDisplayed()){
				System.out.println("Ajax list " + i + " is " + driver.findElement(By.xpath(xP3)).getText());
				i = i+1;
				xP3 = xP1 + i + xP2;
			}
			}catch (NoSuchElementException errMsg){
				System.out.println("Exception occurred for list number "+ i);
				System.out.println(errMsg);
			}
	
		}
	@After
	public void tearDown() throws Exception{
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if(!"".equals(verificationErrorString)){
			fail(verificationErrorString);
		}
	}
	private void fail(String verificationErrorString) {
		// TODO Auto-generated method stub
		
	}
	private boolean isElementPresent(By by){
		try{
			driver.findElement(by);
			return true;
		}catch(NoSuchElementException e){
			return false;
		}
	
				
		
	}

}
