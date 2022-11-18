package com.epam.ui.steps;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

import java.util.Set;

import com.epam.ui.pages.AmazonHomePage;

import net.thucydides.core.annotations.Step;

public class AmazonHomePageSteps {
	AmazonHomePage amazonHomePage;

	@Step
	public void openPage() {
		amazonHomePage.openUrl("https://www.amazon.in/");
	}

	@Step
	public void searchProduct(String productName) {
		amazonHomePage.getSearchField().waitUntilClickable().typeAndEnter(productName);
	}

	@Step
	public void selectFirstProduct() {
		amazonHomePage.evaluateJavascript("arguments[0].scrollIntoView(true);", amazonHomePage.getProductTitles().get(0));
		amazonHomePage.getProductTitles().get(0).waitUntilClickable().click();
	}

	@Step
	public void switchWindow(){
		String currentWindow = getDriver().getWindowHandle();
		Set<String> allWindows = getDriver().getWindowHandles();
		for(String window : allWindows){
			if(!window.equals(currentWindow)){
				getDriver().switchTo().window(window);
				break;
			}
		}
	}
}