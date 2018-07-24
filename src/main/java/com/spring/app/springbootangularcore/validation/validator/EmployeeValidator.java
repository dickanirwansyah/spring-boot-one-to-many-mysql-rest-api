package com.spring.app.springbootangularcore.validation.validator;

import com.spring.app.springbootangularcore.entity.Departement;
import com.spring.app.springbootangularcore.repository.DepartemenRepository;
import com.spring.app.springbootangularcore.validation.EmployeeValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@ComponentScan
public class EmployeeValidator implements ConstraintValidator<EmployeeValidation, String> {

    @Autowired
    private DepartemenRepository departemenRepository;

    @Override
    public void initialize(EmployeeValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        //name not null
        if (value == null || value.isEmpty()){
            return false;
        }

        //name must unique
        Optional<Departement> findByName = departemenRepository.findDepartementByName(value);
        if (findByName.isPresent()){
            return false;
        }
        return true;
    }

}
