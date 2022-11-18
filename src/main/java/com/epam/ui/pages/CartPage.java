package com.epam.ui.pages;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.*;

public class CartPage extends PageObject {
	private final By productTitles = By.xpath("//span[contains(@class,'sc-product-title')]");

	public ListOfWebElementFacades getProductTitles() {
		return findAll(productTitles);
	}
}