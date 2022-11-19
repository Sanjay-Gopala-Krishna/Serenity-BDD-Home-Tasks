package com.epam.ui.steps;

import org.openqa.selenium.StaleElementReferenceException;

import com.epam.ui.pages.ProductPage;

import net.thucydides.core.annotations.Step;


public class ProductPageSteps {
	ProductPage productPage;

	@Step
	public void selectSizeDropdown() {
		productPage.getSizeDropdown().selectByIndex(3);
	}

	@Step
	public void assertAddToCartButtonIsEnabled() {
		try {
			productPage.getAddToCartButton().waitUntilEnabled();
			productPage.getAddToCartButton().waitUntilEnabled().shouldBeEnabled();
		} catch (StaleElementReferenceException e) {
			productPage.getAddToCartButton().waitUntilEnabled();
			productPage.getAddToCartButton().waitUntilEnabled().shouldBeEnabled();
		}
	}

	@Step
	public void clickAddToCartButton() {
		assertAddToCartButtonIsEnabled();
		productPage.getAddToCartButton().waitUntilEnabled().click();
	}
}