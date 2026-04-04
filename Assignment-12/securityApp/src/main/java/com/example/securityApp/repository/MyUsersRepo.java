package com.example.securityApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.securityApp.entities.Myusers;
@Repository
public interface MyUsersRepo extends JpaRepository<Myusers, String>{

}
