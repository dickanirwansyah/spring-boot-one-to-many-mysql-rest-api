package com.spring.app.springbootangularcore.request;

import com.spring.app.springbootangularcore.entity.Departement;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeRequest {

    private String employeeFirstname;
    private String employeeLastname;
    private int employeeAge;
    private long employeeSalary;
    private Departement departementId;
}
