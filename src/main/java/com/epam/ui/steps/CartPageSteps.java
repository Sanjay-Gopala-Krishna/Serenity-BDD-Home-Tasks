package com.epam.ui.steps;

import org.assertj.core.api.Assertions;

import com.epam.ui.pages.CartPage;

import net.thucydides.core.annotations.Step;

public class CartPageSteps {
	CartPage cartPage;

	@Step
	public void assertIsProductAddedToCart() {
		Assertions.assertThat(cartPage.getProductTitles().size()).isEqualTo(1);
	}
}