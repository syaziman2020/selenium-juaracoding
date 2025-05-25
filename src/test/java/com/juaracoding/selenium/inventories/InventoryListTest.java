package com.juaracoding.selenium.inventories;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.juaracoding.selenium.DriverSingleton;

public class InventoryListTest {
	 private WebDriver driver;
	 
	 @BeforeTest
	  public void setup() {
	    System.out.println("SignInTest::setup()");
	    driver = DriverSingleton.createOrGetDriver();
	  }

}
