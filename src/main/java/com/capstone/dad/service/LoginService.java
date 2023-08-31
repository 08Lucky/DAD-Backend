package com.capstone.dad.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.Manager;
import com.capstone.dad.repo.ManagerRepository;

@Service
public class LoginService {

	private final ManagerRepository loginRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginService(ManagerRepository loginRepository, PasswordEncoder passwordEncoder) {
        this.loginRepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isLoginCredentialsValid(String username, String password) {
        Optional<Manager> optionalLogin = Optional.ofNullable(loginRepository.findByUsername(username));
        if (optionalLogin.isPresent()) {
            Manager logindetails = optionalLogin.get();
            return passwordEncoder.matches(password, logindetails.getPassword());
        }
        return false;
    }
    
    public Manager getUserByUsername(String username) {
        return loginRepository.findByUsername(username);
    }
}
