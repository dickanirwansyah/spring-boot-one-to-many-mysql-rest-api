package com.spring.app.springbootangularcore.service;

import com.spring.app.springbootangularcore.entity.Departement;
import com.spring.app.springbootangularcore.request.DepartementRequest;

import java.util.List;
import java.util.Optional;

public interface DepartementService {

    Departement createDepartemen(DepartementRequest request);
    Departement updateDepartemen(long departementId, DepartementRequest request);
    List<Departement> listDepartemen();
    Optional<Departement> findByDepartemenId(long departementId);
}
