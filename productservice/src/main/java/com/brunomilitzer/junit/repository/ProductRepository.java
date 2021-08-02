package com.brunomilitzer.junit.repository;

import com.brunomilitzer.junit.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
