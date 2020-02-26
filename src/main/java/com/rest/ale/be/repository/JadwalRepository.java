package com.rest.ale.be.repository;

import com.rest.ale.be.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface JadwalRepository extends JpaRepository<Jadwal, Long> {
    //Enroll findByFkAkun_IdAkunAndFkKelas_IdKelas(Long fk_akun, Long fk_kelas);
    Jadwal findByRuangAndHariAndJam(String ruang, String hari, LocalTime jam);
}
