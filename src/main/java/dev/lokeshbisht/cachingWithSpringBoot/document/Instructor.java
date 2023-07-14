package dev.lokeshbisht.cachingWithSpringBoot.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Instructor {

    @Id
    private String id;

    private Integer instructorId;

    private String name;

    private String deptName;

    private Double salary;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;
}
