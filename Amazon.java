package kp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Amazon {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.amazon.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Become an Affiliate")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(4000);
		//driver.navigate().to("http://cnn.com");
		//Thread.sleep(4000);
		//driver.findElement(By.linkText("Unlimited Streaming on Prime Instant Video")).click();;
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div[2]/div/div[9]/div/div[1]/div/div/a/img"));

	}

}
