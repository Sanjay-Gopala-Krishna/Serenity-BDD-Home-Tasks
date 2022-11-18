package com.epam.api.dto

import com.fasterxml.jackson.annotation.JsonInclude
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
class BaseDto {
    Integer code
    String type, message
}