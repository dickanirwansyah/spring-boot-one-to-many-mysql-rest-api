package com.spring.app.springbootangularcore.repository;

import com.spring.app.springbootangularcore.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartemenRepository extends JpaRepository<Departement, Long> {

    Optional<Departement> findDepartementByName(String name);
}
