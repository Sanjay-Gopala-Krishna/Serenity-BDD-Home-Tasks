package com.epam.ui;

import static com.epam.staticdata.Messages.PLEASE_CHECK_YOUR_USERNAME_AND_PASSWORD_IF_YOU_STILL_CANT_LOG_IN_CONTACT_YOUR_SALESFORCE_ADMINISTRATOR;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.epam.BaseUiTest;
import com.epam.ui.steps.LoginPageSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class FirstHomeTaskTest extends BaseUiTest {
	@Steps
	LoginPageSteps loginPageSteps;

	@Test
	public void basicOperations(){
		loginPageSteps.openPage();
		loginPageSteps.typeUserName("sanjay");
		loginPageSteps.typePassword("Hello@1234");
		loginPageSteps.clickLoginButton();
		loginPageSteps.assertErrorMessage(PLEASE_CHECK_YOUR_USERNAME_AND_PASSWORD_IF_YOU_STILL_CANT_LOG_IN_CONTACT_YOUR_SALESFORCE_ADMINISTRATOR);
	}
}