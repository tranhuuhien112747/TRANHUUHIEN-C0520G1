package com.code.demo.repository;

import com.code.demo.model.FormCreate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormCreateRepository extends JpaRepository<FormCreate, Long> {
}
