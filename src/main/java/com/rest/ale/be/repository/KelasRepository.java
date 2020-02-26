package com.rest.ale.be.repository;

import com.rest.ale.be.model.Akun;
import com.rest.ale.be.model.Kelas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KelasRepository extends JpaRepository<Kelas, Long>{
}

