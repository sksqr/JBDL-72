package com.example.L16_minor_project_2.repo;

import com.example.L16_minor_project_2.entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatRepo extends JpaRepository<Flat,Long> {

    Flat findByNumber(String number);
}
