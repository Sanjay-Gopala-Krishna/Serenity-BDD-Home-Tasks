package com.epam.ui.steps;

import org.assertj.core.api.Assertions;

import com.epam.ui.pages.LoginPage;

import net.thucydides.core.annotations.Step;

public class LoginPageSteps {
	LoginPage loginPage;

	@Step
	public void openPage(){
		loginPage.open();
	}

	@Step
	public void typeUserName(String userName) {
		loginPage.getUserNameTextField().typeAndTab(userName);
	}

	@Step
	public void typePassword(String password) {
		loginPage.getPasswordTextField().type(password);
	}

	@Step
	public void clickLoginButton() {
		loginPage.getLoginButton().click();
	}

	@Step
	public void assertErrorMessage(String expectedText) {
		Assertions.assertThat(loginPage.getErrorMessage().waitUntilVisible().getText()).isEqualTo(expectedText);
	}
}