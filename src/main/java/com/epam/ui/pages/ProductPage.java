package com.epam.ui.pages;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductPage extends PageObject {
	private final By sizeDropdown = By.xpath("//select[@id='native_dropdown_selected_size_name']");
	private final By addToCartButton = By.xpath("//input[@id='add-to-cart-button']");

	public WebElementFacade getSizeDropdown() {
		return find(sizeDropdown);
	}

	public WebElementFacade getAddToCartButton() {
		return find(addToCartButton);
	}
}