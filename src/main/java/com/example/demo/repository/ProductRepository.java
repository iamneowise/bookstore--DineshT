package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, String> {
Optional<ProductModel> findByProductName(String name);
}
