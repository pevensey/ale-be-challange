package com.rest.ale.be.repository;

import com.rest.ale.be.model.Kelas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KelasRepository extends JpaRepository<Kelas, Long>{
}

