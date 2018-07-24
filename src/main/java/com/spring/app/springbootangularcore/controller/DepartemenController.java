package com.spring.app.springbootangularcore.controller;

import com.spring.app.springbootangularcore.entity.Departement;
import com.spring.app.springbootangularcore.request.DepartementRequest;
import com.spring.app.springbootangularcore.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/departemen")
public class DepartemenController {

    @Autowired
    private DepartementService departementService;

    @PostMapping
    public ResponseEntity<Departement> create(@Valid @RequestBody DepartementRequest request){
        return Optional.ofNullable(departementService.createDepartemen(request))
                .map(callbackJSON-> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Departement>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping
    public ResponseEntity<List<Departement>> list(){
        return Optional.ofNullable(departementService.listDepartemen())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Departement>>(HttpStatus.NOT_FOUND));
    }
}
