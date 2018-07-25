package com.spring.app.springbootangularcore.request;


import com.spring.app.springbootangularcore.validation.EmployeeValidation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartementRequest {

    private long departementId;

    @EmployeeValidation
    private String departementName;

    private boolean departementActive;
}
