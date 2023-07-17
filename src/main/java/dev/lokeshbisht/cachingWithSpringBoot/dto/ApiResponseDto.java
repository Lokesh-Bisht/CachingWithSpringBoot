package dev.lokeshbisht.cachingWithSpringBoot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDto<T> {

    private T data;

    private String message;

    @JsonProperty("metadata")
    private MetaDataDto metaDataDto;
}
