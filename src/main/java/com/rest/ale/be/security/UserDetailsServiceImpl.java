package com.rest.ale.be.security;

import com.rest.ale.be.model.Akun;
import com.rest.ale.be.repository.AkunRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private AkunRepository akunRepo;

    public UserDetailsServiceImpl(AkunRepository akunRepository) {
        this.akunRepo = akunRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Akun akun = akunRepo.findByUsername(username);
        if (akun == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(akun.getUsername(), akun.getPassword(), emptyList());
    }
}
