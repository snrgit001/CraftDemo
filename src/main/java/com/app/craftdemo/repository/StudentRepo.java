package com.app.craftdemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.craftdemo.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

}
