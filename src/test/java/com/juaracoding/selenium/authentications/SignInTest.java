package com.juaracoding.selenium.authentications;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.juaracoding.selenium.DriverSingleton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SignInTest {
  WebDriver driver;
  WebElement usernameField;
  WebElement passwordField;
  WebElement buttonLogin;

  @BeforeClass
  public void setup() throws InterruptedException {
    Thread.sleep(3000);
    driver = DriverSingleton.createOrGetDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @Test
  public void testStep01() throws InterruptedException {
    usernameField = driver.findElement(By.id("user-name"));
    passwordField = driver.findElement(By.id("password"));
    buttonLogin = driver.findElement(By.id("login-button"));

    Thread.sleep(3000);
    usernameField.sendKeys("standard_user");
    System.out.println("INI DIAAAA => " + passwordField.getText());
    passwordField.sendKeys("secret_sauce");
    buttonLogin.click();

    String expected = "https://www.saucedemo.com/v1/inventory.html";
    String actual = driver.getCurrentUrl();

    System.out.println(actual);

    Assert.assertEquals(actual, expected);
  }

}

