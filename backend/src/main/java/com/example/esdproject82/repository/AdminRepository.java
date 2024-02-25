package com.example.esdproject82.repository;

import com.example.esdproject82.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByEmail(String email);
    Optional <Admin> findOneByEmailAndPassword(String email,String password);
}