package dev.lokeshbisht.cachingWithSpringBoot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDto<T> implements Serializable {

    private T data;

    private String message;

    @JsonProperty("metadata")
    private MetaDataDto metaDataDto;
}
