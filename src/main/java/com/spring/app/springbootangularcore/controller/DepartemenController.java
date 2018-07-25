package com.spring.app.springbootangularcore.controller;

import com.spring.app.springbootangularcore.entity.Departement;
import com.spring.app.springbootangularcore.exception.NotFoundException;
import com.spring.app.springbootangularcore.repository.DepartemenRepository;
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
@CrossOrigin(origins = {"*"})
public class DepartemenController {

    @Autowired
    private DepartementService departementService;

    @Autowired
    private DepartemenRepository departemenRepository;

    @PostMapping
    public ResponseEntity<Departement> create(@Valid @RequestBody DepartementRequest request){
        return Optional.ofNullable(departementService.createDepartemen(request))
                .map(callbackJSON-> new ResponseEntity<>(callbackJSON, HttpStatus.CREATED))
                .orElse(new ResponseEntity<Departement>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping(value = "/{departemenId}")
    public ResponseEntity<Optional<Departement>> getId(@PathVariable("departemenId")long departemenId){
        return Optional.ofNullable(departementService.findByDepartemenId(departemenId))
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<Optional<Departement>>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/{departementId}")
    public Departement update(@PathVariable("departementId")long departementId,
                              @RequestBody DepartementRequest request){
       return departemenRepository.findById(departementId)
               .map(departement -> {
                   departement.setName(request.getDepartementName());
                   departement.setActive(request.isDepartementActive());
                   return departemenRepository.save(departement);
               }).orElseThrow(() -> new NotFoundException("maaf departementId :"+departementId+" tidak ditemukan"));
    }

    @GetMapping
    public ResponseEntity<List<Departement>> list(){
        return Optional.ofNullable(departementService.listDepartemen())
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .orElse(new ResponseEntity<List<Departement>>(HttpStatus.NOT_FOUND));
    }
}
