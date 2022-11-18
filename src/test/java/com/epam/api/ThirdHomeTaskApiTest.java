package com.epam.api;

import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.epam.api.dto.PetStoreDto;
import com.epam.api.steps.PetStoreApiSteps;
import com.epam.api.steps.ResponseValidationApiSteps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class ThirdHomeTaskApiTest {
	@Steps
	PetStoreApiSteps petStoreApiSteps;
	@Steps
	ResponseValidationApiSteps responseValidationApiSteps;

	@Test
	public void shouldVerifyStatusCode() {
		Response getPetResponse = petStoreApiSteps.sendGetPetByFindByStatus("available");
		responseValidationApiSteps.validateResponseCode(getPetResponse, HttpStatus.SC_OK);
	}

	@Test
	public void shouldValidateStatusOfAllPets() {
		Response getPetResponse = petStoreApiSteps.sendGetPetByFindByStatus("available");
		responseValidationApiSteps.validateResponseCode(getPetResponse, HttpStatus.SC_OK);

		PetStoreDto[] getAllPetDetailsDto = getPetResponse.as(PetStoreDto[].class);

		Assertions.assertThat(getAllPetDetailsDto).extracting("status").containsOnly("available");
		Assertions.assertThat(getAllPetDetailsDto.length).isGreaterThan(5);
		System.out.println("Number of pets returned in the response is = " + getAllPetDetailsDto.length);
	}

	@Test
	public void shouldVerifyContentTypeAndHeader() {
		Response getPetResponse = petStoreApiSteps.sendGetPetByFindByStatus("available");
		responseValidationApiSteps.validateResponseCode(getPetResponse, HttpStatus.SC_OK);

		Assertions.assertThat(getPetResponse.getContentType()).isEqualTo(ContentType.JSON.toString());
		Assertions.assertThat(getPetResponse.getHeader("Access-Control-Allow-Methods")).isEqualTo("GET, POST, DELETE, PUT");
	}

	@Test
	public void shouldReturnNotFound() {
		Response getPetResponse = petStoreApiSteps.sendGetPetByFindByStatus();
		responseValidationApiSteps.validateResponseCode(getPetResponse, HttpStatus.SC_NOT_FOUND);
	}
}