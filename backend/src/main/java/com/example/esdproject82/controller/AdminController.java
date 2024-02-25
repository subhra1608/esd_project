package com.example.esdproject82.controller;

import com.example.esdproject82.DTO.Login;
import com.example.esdproject82.DTO.LoginMessage;
import com.example.esdproject82.model.Admin;
import com.example.esdproject82.repository.AdminRepository;
import com.example.esdproject82.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/register")
    public ResponseEntity<String> RegisterAdmin(@RequestBody Admin adminData) {
        adminService.saveAdmin(adminData);
        return new ResponseEntity<>("Admin created successfully", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee(@RequestBody Login login){
        LoginMessage loginMessage=adminService.loginEmployee(login);
        return ResponseEntity.ok(loginMessage);
    }

}