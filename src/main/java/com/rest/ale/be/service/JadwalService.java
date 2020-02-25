package com.rest.ale.be.service;

import com.rest.ale.be.exception.ResourceTidakTersedia;
import com.rest.ale.be.model.Jadwal;
import com.rest.ale.be.model.Kelas;
import com.rest.ale.be.repository.JadwalRepository;
import com.rest.ale.be.repository.KelasRepository;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.*;

@Service
public class JadwalService {


    @Autowired
    JadwalRepository JadwalRepo;

    @Autowired
    KelasRepository kelasRepo;

    public List<Jadwal> getAllJadwals() {
        return JadwalRepo.findAll();
    }


    public Optional<Jadwal> getJadwalById(Long JadwalId) {
        if (!JadwalRepo.existsById(JadwalId)) {
            throw new ResourceTidakTersedia("Maaf, jadwal dengan id " + JadwalId + " tidak ada");
        }
        return JadwalRepo.findById(JadwalId);
    }


    public Jadwal createJadwal(Long idKelas, Jadwal jadwal) {
        List<Jadwal> jadwals = new ArrayList<>();
        Kelas kelas = new Kelas();

        Optional<Kelas> byId = kelasRepo.findById(idKelas);
        if (!byId.isPresent()) {
            throw new ResourceTidakTersedia("Maaf, kelas dengan id " + idKelas + " tidak ada");
        }
        Kelas ambilKelas = byId.get();

        //tie Kelas to Jadwal
        jadwal.setFk_kelas(ambilKelas);

        Jadwal jadwalBaru = JadwalRepo.save(jadwal);
        //tie Jadwal to Kelas
        jadwals.add(jadwalBaru);
        kelas.setJadwals(jadwals);

        return jadwalBaru;

    }

//    public Jadwal updateJadwalById(Long JadwalId, Jadwal JadwalRequest) {
//        if (!JadwalRepo.existsById(JadwalId)) {
//            throw new ResourceTidakTersedia("Jadwal with id " + JadwalId + " not found");
//        }
//        Optional<Jadwal> Jadwal = JadwalRepo.findById(JadwalId);
//
//        if (!Jadwal.isPresent()) {
//            throw new ResourceTidakTersedia("Jadwal with id " + JadwalId + " not found");
//        }
//
//        Jadwal Jadwal1 = Jadwal.get();
//        Jadwal1.setGenre(JadwalRequest.getGenre());
//        Jadwal1.setTitle(JadwalRequest.getTitle());
//
//        return JadwalRepo.save(Jadwal1);
//    }
//
//    public ResponseEntity<Object> deleteJadwalById(long JadwalId) {
//        if (!JadwalRepo.existsById(JadwalId)) {
//            throw new ResourceTidakTersedia("Jadwal with id " + JadwalId + " not found");
//        }
//
//        JadwalRepo.deleteById(JadwalId);
//
//        return ResponseEntity.ok().build();
//
//    }
}
