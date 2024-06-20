package com.nextstep.springauth.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
public class AssignmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int assignment_id;

    @NotBlank(message = "Name is mandatory")
    @NotNull(message = "Name should not be blank")
    private String assignment_title;
    @NotBlank(message = "Image Name is mandatory")
    private String image_url;
    @NotNull(message = "Date is mandatory")
    private LocalDate assignment_date;
    @NotBlank(message = "Semester is mandatory")
    private String semester;

    @NotBlank(message = "Subject is mandatory")
    private String subject;

}
