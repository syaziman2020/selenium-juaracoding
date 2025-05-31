package com.juaracoding.selenium.listeners;


import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import com.juaracoding.selenium.helper.screenshoot.ScreenshotHelper;



public class HookSS implements IInvokedMethodListener {
  @Override
  public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
    log("Commencing", method);
    WebDriver driver = (WebDriver) testResult.getTestContext().getAttribute("driver");
    ScreenshotHelper.takeScreenshot(method.getTestMethod().getMethodName() + "_before.png",
        driver);
  }

  @Override
  public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    log("Completed", method);
    WebDriver driver = (WebDriver) testResult.getTestContext().getAttribute("driver");
    ScreenshotHelper.takeScreenshot(method.getTestMethod().getMethodName() + "_after.png",
        driver);
  }

  private static void log(String prefix, IInvokedMethod method) {
    String type = "Configuration";
    if (method.isTestMethod()) {
      type = "Test";
    }
    String msg = prefix + " executing [" + type + "] method "
        + method.getTestMethod().getQualifiedName();
    System.err.println(msg);
  }

}
