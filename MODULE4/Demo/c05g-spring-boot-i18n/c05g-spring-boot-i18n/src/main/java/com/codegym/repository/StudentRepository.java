package com.codegym.repository;

import com.codegym.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByBirthday(String birthday);
    List<Student> findByBirthdayAndNameOrderById(String birthday, String name);
    List<Student> findByBirthdayLessThan(String birthday);
    Page<Student> findByNameContaining(String keyword, Pageable pageable);
    List<Student> findByClassStudent_Id(Integer id);

    /*
    select *
    from Student
    where name like ?1 or birthday like ?2
     */
    Page<Student> findByNameContainingOrBirthdayContaining(String keyword, String abc, Pageable pageable);

    Page<Student> findByIdOrNameOrBirthdayOrderByIdDesc(Integer a, String b, String c, Pageable pageable);
}
