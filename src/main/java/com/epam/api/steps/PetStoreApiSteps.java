package com.epam.api.steps;

import com.epam.api.BaseRequests;
import com.epam.api.config.RequestSpec;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;

public class PetStoreApiSteps extends BaseRequests {
	@Step
	public Response sendGetPetByFindByStatus(String status) {
		RequestSpecification spec = RequestSpec
				.buildCommonSpec()
				.basePath("pet/findByStatus")
				.queryParam("status", status);
		return sendGetRequest(spec);
	}

	@Step
	public Response sendGetPetByFindByStatus() {
		RequestSpecification spec = RequestSpec
				.buildCommonSpec()
				.basePath("pet/findByStatue");
		return sendGetRequest(spec);
	}

	@Step
	public Response sendPostPet(Object body) {
		RequestSpecification spec = RequestSpec
				.buildCommonSpec()
				.basePath("pet")
				.body(body)
				.contentType(ContentType.JSON);
		return sendPostRequest(spec);
	}

	@Step
	public Response sendDeletePetByPetId(int petId) {
		RequestSpecification spec = RequestSpec
				.buildCommonSpec()
				.basePath("pet/{petId}")
				.pathParam("petId", petId);
		return sendDeleteRequest(spec);
	}
}