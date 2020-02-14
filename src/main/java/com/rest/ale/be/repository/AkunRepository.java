package com.rest.ale.be.repository;

import com.rest.ale.be.model.Akun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AkunRepository extends JpaRepository<Akun, Long> {
    Akun findByUsername(String username);
}
