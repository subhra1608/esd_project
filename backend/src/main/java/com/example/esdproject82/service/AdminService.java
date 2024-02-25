package com.example.esdproject82.service;
import com.example.esdproject82.DTO.Login;
import com.example.esdproject82.DTO.LoginMessage;
import com.example.esdproject82.model.Admin;
import com.example.esdproject82.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginMessage loginEmployee(Login login) {
        String msg="";
        Admin adminFromRequest = adminRepository.findByEmail(login.getEmail());
        if(adminFromRequest!=null){
            String passwordFromRequest=login.getPassword();
            String passwordFromAdmin=adminFromRequest.getPassword();
            Boolean isPwdRight=passwordEncoder.matches(passwordFromRequest,passwordFromAdmin);
            if(isPwdRight){
                Optional<Admin> admin=adminRepository.findOneByEmailAndPassword(login.getEmail(),passwordFromAdmin);
                if(admin.isPresent()){
                    return new LoginMessage("Login Success",true);
                }
                else{
                    return new LoginMessage("Login failed",false);
                }
            }
            else {
                return new LoginMessage("Password not match", false);
            }
        }
        else{
            return new LoginMessage("Email not exits",false);
        }
    }
    public void saveAdmin(Admin adminData) {
        String encodedPassword=this.passwordEncoder.encode(adminData.getPassword());
        adminData.setPassword((encodedPassword));
        adminRepository.save(adminData);
    }
}