package com.codegym.demo.repository;

import com.codegym.demo.model.ProductManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductManager, Integer> {
//
    Page<ProductManager> findByName(String name, Pageable pageable);
//
//    List<ProductManager> findByNameContainingOrAddressContaining(String name, String address);


//    @Query("select s from Student s where s.name = :input and s.age > 15")
//    List<Student> findByName(@Param("input") String name);

}
