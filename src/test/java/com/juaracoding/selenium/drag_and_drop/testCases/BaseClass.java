package com.juaracoding.selenium.drag_and_drop.testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	
	@BeforeClass
	@Parameters({"url"})
	public void setup(String url, ITestContext context) {
		driver = new ChromeDriver();
		
		context.setAttribute("driver", driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.get(url);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
