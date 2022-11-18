package com.epam.api.config;

import java.util.Arrays;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {
    public static final String BASE_URL = "https://petstore.swagger.io/v2/";
    private static final String AUTH_HEADER = "Authentication";
    private static final String AUTH_KEY = "special-key";

    public static RequestSpecification buildCommonSpec() {
        return new RequestSpecBuilder()
                .addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                .setBaseUri(BASE_URL)
                .addHeader(AUTH_HEADER, AUTH_KEY)
                .build();
    }
}