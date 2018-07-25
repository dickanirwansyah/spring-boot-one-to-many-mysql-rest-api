package com.spring.app.springbootangularcore.service.imp;

import com.spring.app.springbootangularcore.entity.Departement;
import com.spring.app.springbootangularcore.repository.DepartemenRepository;
import com.spring.app.springbootangularcore.request.DepartementRequest;
import com.spring.app.springbootangularcore.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DepartementServiceImpl implements DepartementService {

    @Autowired
    private DepartemenRepository departemenRepository;

    @Override
    public Departement createDepartemen(DepartementRequest request) {
        Departement departement = newDepartement(request.getDepartementName());
        return departemenRepository.save(departement);
    }

    @Override
    public Departement updateDepartemen(long departementId, DepartementRequest request) {
        return null;
    }

    private Departement newDepartement(String name){
        return Departement.builder()
                .name(name)
                .build();
    }

    @Override
    public List<Departement> listDepartemen() {
        List<Departement> departements = new ArrayList<>();
        for (Departement departement: departemenRepository.findAll()){
            departements.add(departement);
        }
        return departements;
    }

    @Override
    public Optional<Departement> findByDepartemenId(long departementId) {
        return departemenRepository.findById(departementId);
    }


}
