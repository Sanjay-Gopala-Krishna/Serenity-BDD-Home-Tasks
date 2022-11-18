package com.epam.ui.pages;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.*;

public class ViewItemsAddedPage extends PageObject {
	private final By goToCartButton = By.xpath("//span[@id='sw-gtc']");

	public WebElementFacade getGoToCartButton() {
		return find(goToCartButton);
	}
}