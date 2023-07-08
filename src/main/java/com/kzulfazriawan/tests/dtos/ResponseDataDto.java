package com.kzulfazriawan.tests.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDataDto {
    private Integer status;
    private String message;
    private Object data;
}
