package com.code.shop.repository;

import com.code.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
