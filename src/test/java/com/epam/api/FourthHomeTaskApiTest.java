package com.epam.api;

import java.util.List;

import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.epam.api.dto.*;
import com.epam.api.steps.PetStoreApiSteps;
import com.epam.api.steps.ResponseValidationApiSteps;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class FourthHomeTaskApiTest {
	@Steps
	PetStoreApiSteps petStoreApiSteps;
	@Steps
	ResponseValidationApiSteps responseValidationApiSteps;

	@Test
	public void shouldAddNewPetToStore() {
		IdNameDto catalogIdNameDto = new IdNameDtoBuilder().id(98L).name("catalog").build();
		IdNameDto tagsIdNameDto = new IdNameDtoBuilder().id(99L).name("tags").build();
		PetStoreDto petStoreDto = new PetStoreDtoBuilder().id(100L).category(catalogIdNameDto).name("doggie")
				.photoUrls(List.of("www.doggie.com")).tags(List.of(tagsIdNameDto)).status("available").build();

		Response response = petStoreApiSteps.sendPostPet(petStoreDto);
		responseValidationApiSteps.validateResponseCode(response, HttpStatus.SC_OK);

		PetStoreDto responseDto = response.as(PetStoreDto.class);

		Assertions.assertThat(responseDto.getId()).isEqualTo(petStoreDto.getId());
		Assertions.assertThat(responseDto.getName()).isEqualTo(petStoreDto.getName());
	}

	@Test
	public void shouldDeleteAPet() {
		Response response = petStoreApiSteps.sendDeletePetByPetId(100);
		responseValidationApiSteps.validateResponseCode(response, HttpStatus.SC_OK);

		BaseDto responseDto = response.as(BaseDto.class);

		Assertions.assertThat(responseDto.getCode()).isEqualTo(200);
		Assertions.assertThat(responseDto.getMessage()).isEqualTo("100");
	}
}