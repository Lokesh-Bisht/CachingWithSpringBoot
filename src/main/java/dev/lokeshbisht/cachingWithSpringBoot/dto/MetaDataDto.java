package dev.lokeshbisht.cachingWithSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MetaDataDto implements Serializable {

    private Integer page;

    private Integer size;

    private Integer total;

    private Long took;
}
