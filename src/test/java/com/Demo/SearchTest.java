package com.Demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest {

	WebDriver driver;
	static String driverPath = "/Users/shubhsinghal/Downloads/Driver/chromedriver";

	@Test
	@Parameters({ "author", "searchKey" })
	public void testNoParameter(String author, String searchKey) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", driverPath);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement searchText = driver.findElement(By.name("q"));
		
		searchText.sendKeys(searchKey);

		System.out.println("Welcome ->" + author + " Your search key is->" + searchKey);
		System.out.println("Value in Google Search Box = " + searchText.getAttribute("value")
				+ " ::: Value given by input = " + searchKey);
		driver.close();
	}
}
