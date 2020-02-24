package com.rest.ale.be.repository;

import com.rest.ale.be.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JadwalRepository extends JpaRepository<Jadwal, Long> {
//    @Query("SELECT new com.rest.ale.be.model.LihatJadwal (v.id, v.fileName, v.fileType) FROM DBFile v")
//    List<GetFile> lihatJadwals();
//
//    @Query("SELECT new com.rest.ale.be.model.LihatJadwal (v.id, v.ruang, v.waktu, v.fk, v.matkul, v.dosen) FROM LihatJadwal v")
//    List<GetFile> lihatJadwal();
   // List<Jadwal> findByFk_kelas();
   // List<Jadwal> findByFk_kelasAndKelas(Kelas zipCode);
}
