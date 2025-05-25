package com.juaracoding.selenium.drag_and_drop.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.selenium.drag_and_drop.pages.DragDropPage;

public class DragAndDropTest extends BaseClass{
	
	@Test
	public void dragAndDropTest() throws InterruptedException {
		
		DragDropPage page = new DragDropPage(driver);

		for(String[] pairs:keyElements) {
			page.dropAction(pairs[0], pairs[1]);
		}
		
		Thread.sleep(3000);
		
		System.out.println("masuk pak eko");
		for(String[] pairs:keyElements) {
			page.dropToBeginning(pairs[0]);
		}
		
		Assert.assertEquals(page.getSizeDragBeginning(), 7);
	}
	
	String[][] keyElements = {
			{"box1","box101" },
			{"box2","box102" },
			{"box3","box103" },
			{"box4","box104" },
			{"box5","box105" },
			{"box6","box106" },
			{"box7","box107" },
	};

}
