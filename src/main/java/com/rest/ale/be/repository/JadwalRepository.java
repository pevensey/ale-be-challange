package com.rest.ale.be.repository;

import com.rest.ale.be.model.Akun;
import com.rest.ale.be.model.Jadwal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JadwalRepository extends JpaRepository<Jadwal, Long> {
    //Akun findByUsername(String username);
}
