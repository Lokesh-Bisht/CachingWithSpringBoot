package dev.lokeshbisht.cachingWithSpringBoot.document;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document
public class Instructor implements Serializable {

    @Id
    private String id;

    private Long instructorId;

    @NotNull(message = "Missing instructor name.")
    private String name;

    @NotNull(message = "Missing department name.")
    private String deptName;

    @NotNull(message = "Missing instructor name.")
    @Min(value = 20000, message = "Instructor's salary per month should be at least 20000")
    private Double salary;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;
}
