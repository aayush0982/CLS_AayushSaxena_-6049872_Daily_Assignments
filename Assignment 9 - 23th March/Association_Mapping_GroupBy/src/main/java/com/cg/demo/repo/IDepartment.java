package com.cg.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.demo.entities.Department;

@Repository
public interface IDepartment extends JpaRepository<Department, Integer> {

}
