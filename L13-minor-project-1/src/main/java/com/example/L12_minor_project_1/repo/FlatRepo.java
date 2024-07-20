package com.example.L12_minor_project_1.repo;

import com.example.L12_minor_project_1.entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRepo extends JpaRepository<Flat,Long> {

    Flat findByNumber(String number);
}
