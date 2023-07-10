package com.kzulfazriawan.tests.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

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
    private String description;

}
