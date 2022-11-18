package com.epam.api.steps;

import org.assertj.core.api.Assertions;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

public class ResponseValidationApiSteps {
	@Step
	public void validateResponseCode(Response resp, int expectedStatusCode) {
		Assertions.assertThat(resp.statusCode()).as("Status code is not '%s'", expectedStatusCode).isEqualTo(
				expectedStatusCode);
	}
}