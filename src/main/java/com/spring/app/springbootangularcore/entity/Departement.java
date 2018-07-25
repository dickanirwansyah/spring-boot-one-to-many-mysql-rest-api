package com.spring.app.springbootangularcore.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "tbl_departemen")
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long iddepartement;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "active")
    private boolean active;

}
