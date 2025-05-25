package com.juaracoding.selenium.authentications;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.juaracoding.selenium.DriverSingleton;

public class SignInWithoutUsernameTest {
  WebDriver driver;
  WebElement passwordField;
  WebElement buttonLogin;

  @BeforeClass
  public void setup() throws InterruptedException {
    System.out.println("SignInWithoutUsernameTest::setup");
    Thread.sleep(3000);
    driver = DriverSingleton.createOrGetDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    passwordField = driver.findElement(By.id("password"));
    buttonLogin = driver.findElement(By.id("login-button"));

  }

  @Test
  public void testStep01() throws InterruptedException {
    System.out.println("SignInWithoutUsernameTest::testStep01");
    Thread.sleep(3000);

    passwordField.sendKeys("secret_sauce");
//    buttonLogin.click();
//    passwordField.clear();
    Thread.sleep(3000);
  }
}
