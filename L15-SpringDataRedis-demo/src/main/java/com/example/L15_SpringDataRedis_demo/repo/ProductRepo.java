package com.example.L15_SpringDataRedis_demo.repo;

import com.example.L15_SpringDataRedis_demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
