package com.capstone.dad.jwt;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capstone.dad.entity.Manager;
import com.capstone.dad.repo.ManagerRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ManagerRepository managerRepository;

    public UserDetailsServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Manager manager = managerRepository.findByUsername(username);
        if (manager == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(manager);
    }
}
