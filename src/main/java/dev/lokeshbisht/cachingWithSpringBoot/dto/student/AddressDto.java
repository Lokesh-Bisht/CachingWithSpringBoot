package dev.lokeshbisht.cachingWithSpringBoot.dto.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

    private String address;

    private String city;

    private String state;

    @JsonProperty("zip_code")
    private String zipCode;
}
