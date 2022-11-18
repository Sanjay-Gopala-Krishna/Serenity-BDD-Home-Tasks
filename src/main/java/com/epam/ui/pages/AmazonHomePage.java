package com.epam.ui.pages;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.*;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;

@NamedUrls({ @NamedUrl(name = "amazonHomePage", url = "https://www.amazon.in/") })
public class AmazonHomePage extends PageObject {
	private final By searchField = By.xpath("//input[@id='twotabsearchtextbox']");
	private final By productTitles = By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']");

	public WebElementFacade getSearchField() {
		return find(searchField);
	}

	public ListOfWebElementFacades getProductTitles() {
		return findAll(productTitles);
	}
}