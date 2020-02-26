package com.rest.ale.be.repository;

import com.rest.ale.be.model.Enroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollRepository extends JpaRepository<Enroll, Long> {
    Enroll findByFkAkun_IdAkunAndFkKelas_IdKelas(Long fk_akun, Long fk_kelas);
}
