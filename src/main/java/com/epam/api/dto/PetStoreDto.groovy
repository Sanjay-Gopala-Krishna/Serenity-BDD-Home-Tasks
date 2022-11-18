package com.epam.api.dto


import com.fasterxml.jackson.annotation.JsonInclude
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.builder.Builder
import groovy.transform.builder.ExternalStrategy

@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
class PetStoreDto extends BaseDto {
    Long id
    IdNameDto category
    String name, status
    List<String> photoUrls
    List<IdNameDto> tags
}

class IdNameDto {
    Long id
    String name
}

@Builder(builderStrategy = ExternalStrategy, forClass = IdNameDto)
class IdNameDtoBuilder {
}

@Builder(builderStrategy = ExternalStrategy, forClass = PetStoreDto)
class PetStoreDtoBuilder {
}