package com.epam.ui;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.epam.BaseUiTest;
import com.epam.ui.steps.*;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class SecondHomeTaskTest extends BaseUiTest {
	@Steps
	AmazonHomePageSteps amazonHomePageSteps;
	@Steps
	ProductPageSteps productPageSteps;
	@Steps
	CartPageSteps cartPageSteps;
	@Steps
	ViewItemsAddedPageSteps viewItemsAddedPageSteps;

	@Test
	public void shouldSearchAndAddProductToCart(){
		amazonHomePageSteps.openPage();
		amazonHomePageSteps.searchProduct("Nike");
		amazonHomePageSteps.selectFirstProduct();
		amazonHomePageSteps.switchWindow();
		productPageSteps.selectSizeDropdown();
		productPageSteps.assertAddToCartButtonIsEnabled();
		productPageSteps.clickAddToCartButton();
		viewItemsAddedPageSteps.clickGoToCartButton();
		cartPageSteps.assertIsProductAddedToCart();
	}
}