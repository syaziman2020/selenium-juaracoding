package com.juaracoding.selenium.authentications;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.juaracoding.selenium.DriverSingleton;

public class SignInWithoutPasswordTest {
	  WebDriver driver;
	  WebElement usernameField;
	  WebElement buttonLogin;

	  @BeforeClass
	  public void setup() throws InterruptedException {
	    System.out.println("SignInWithoutPasswordTest::setup");
	    Thread.sleep(3000);
	    driver = DriverSingleton.createOrGetDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    usernameField = driver.findElement(By.id("user-name"));
	    buttonLogin = driver.findElement(By.id("login-button"));
	  }

	  @Test
	  public void testStep01() throws InterruptedException {
	    System.out.println("SignInWithoutPasswordTest::testStep01");
	    Thread.sleep(3000);
	    usernameField.sendKeys("standard_user");
	    buttonLogin.click();
	    usernameField.clear();
	    Thread.sleep(3000);
	  }
	}