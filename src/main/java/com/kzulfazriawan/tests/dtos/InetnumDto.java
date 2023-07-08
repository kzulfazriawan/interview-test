package com.kzulfazriawan.tests.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InetnumDto {
    private long id;

    @NotEmpty
    private String inetNum;

    @NotEmpty
    private String netName;

    @NotEmpty
    private String country;

    @NotEmpty
    private String status;

    @NotEmpty
    private String description;

    @NotEmpty
    private Timestamp lastModified;

}
