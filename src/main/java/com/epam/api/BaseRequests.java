package com.epam.api;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseRequests {
	protected Response sendGetRequest(RequestSpecification requestSpecification) {
		return given().spec(requestSpecification).when().get().then().extract().response();
	}

	protected Response sendPostRequest(RequestSpecification requestSpecification) {
		return given().spec(requestSpecification).when().post().then().extract().response();
	}

	protected Response sendDeleteRequest(RequestSpecification requestSpecification) {
		return given().spec(requestSpecification).when().delete().then().extract().response();
	}

	protected Response sendPatchRequest(RequestSpecification requestSpecification) {
		return given().spec(requestSpecification).when().patch().then().extract().response();
	}

	protected Response sendPutRequest(RequestSpecification requestSpecification) {
		return given().spec(requestSpecification).when().put().then().extract().response();
	}
}
