package com.epam.ui.steps;

import com.epam.ui.pages.ViewItemsAddedPage;

import net.thucydides.core.annotations.Step;

public class ViewItemsAddedPageSteps {
	ViewItemsAddedPage viewItemsAddedPage;

	@Step
	public void clickGoToCartButton() {
		viewItemsAddedPage.getGoToCartButton().waitUntilClickable().click();
	}
}