package com.naresh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naresh.modal.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
