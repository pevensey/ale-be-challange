package com.rest.ale.be.repository;

import com.rest.ale.be.model.Enroll;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollRepository extends JpaRepository<Enroll, Long> {

    Enroll findByFkAkun_IdAkunAndFkKelas_IdKelas(Long fk_akun, Long fk_kelas);
}
