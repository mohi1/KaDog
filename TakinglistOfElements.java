package kp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TakinglistOfElements {

	public static void main(String[] args) {
     WebDriver driver = new FirefoxDriver();
     driver.navigate().to("http://www.amazon.com/");
     
     List<WebElement>list = driver.findElements(By.tagName("a"));
     int myList = list.size();
     System.out.println("number of list "+myList);
     
	}

}
