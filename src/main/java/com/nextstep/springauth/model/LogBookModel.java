package com.nextstep.springauth.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class LogBookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lb_id;

    @NotNull(message = "Unit number is mandatory")
    private Integer unit_number;

    @NotBlank(message = "Topic is mandatory")
    private String topic;

    @NotBlank(message = "Teaching activities are mandatory")
    private String teaching_activities;

    @NotBlank(message = "Teaching material is mandatory")
    private String teaching_material;

    @NotNull(message = "Number of present students is mandatory")
    private Integer number_of_present_students;

    private String remarks;
}
