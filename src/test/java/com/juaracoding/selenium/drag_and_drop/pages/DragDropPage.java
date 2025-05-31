package com.juaracoding.selenium.drag_and_drop.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragDropPage extends BasePage {

	public DragDropPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='dropContent']//div[@class='dragableBox']")
	List<WebElement> dragElements;

	@FindBy(xpath = "//div[@id='countries']/div[@class='dragableBoxRight']")
	List<WebElement> dropElements;
	
	@FindBy(xpath = "//div[@id='countries']/div[@class='dragableBoxRight']/div[@class='dragableBox']")
	List<WebElement> dragAfterElements;
	
	@FindBy(xpath = "//div[@id='mainContainer']")
	WebElement areaScroll;
	
	@FindBy(xpath = "//div[@id='capitals']")
	WebElement sourceArea;

	public void dropAction(String source, String target) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);", areaScroll);
		
		Actions acts = new Actions(driver);
		WebElement sourceElement = null;
		WebElement targetElement = null;

		for (WebElement drag : dragElements) {
			if (drag.getDomProperty("id").equals(source)) {
				sourceElement = drag;
				break;
			}

		}
		for (WebElement drop : dropElements) {
			if (drop.getDomProperty("id").equals(target)) {
				targetElement = drop;
				break;
			}
		}
		
		if (sourceElement != null && targetElement != null) {
			acts.dragAndDrop(sourceElement, targetElement).perform();
		}

	}
	
	public void dropToBeginning(String source) {
		Actions acts = new Actions(driver);
		
		for (WebElement drag : dragAfterElements) {
			if (drag.getDomProperty("id").equals(source)) {
				acts.dragAndDrop(drag, sourceArea).perform();
				break;
			}

		}
	}
	
	public int getSizeDragBeginning() {
		return dragElements.size();
	}
	
	public boolean statusGreen() {
		int helperCount = 0;
		for(WebElement drag:dragAfterElements) {
			
			System.out.println("color: "+drag.getCssValue("background-color"));
			if(drag.getCssValue("background-color").equals("rgba(0, 255, 0, 1)")) {
				helperCount++;
			}
			
		}
		return (helperCount >= dragAfterElements.size());
	}

}
