package com.epam.ui.pages;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;

@NamedUrls({ @NamedUrl(name = "loginPage", url = "https://login.salesforce.com/") })
public class LoginPage extends PageObject {
	private final By userNameTextField = By.xpath("//input[@id='username']");
	private final By passwordTextField = By.xpath("//input[@id='password']");
	private final By loginButton = By.xpath("//input[@id='Login']");
	private final By errorMessage = By.xpath("//div[@id='error']");

	public WebElementFacade getUserNameTextField() {
		return find(userNameTextField);
	}

	public WebElementFacade getPasswordTextField() {
		return find(passwordTextField);
	}

	public WebElementFacade getLoginButton() {
		return find(loginButton);
	}

	public WebElementFacade getErrorMessage() {
		return find(errorMessage);
	}
}