package com.rest.ale.be.service;

import com.rest.ale.be.exception.ResourceTidakTersedia;
import com.rest.ale.be.model.Akun;
import com.rest.ale.be.model.Enroll;
import com.rest.ale.be.model.Jadwal;
import com.rest.ale.be.model.Kelas;
import com.rest.ale.be.repository.AkunRepository;
import com.rest.ale.be.repository.EnrollRepository;
import com.rest.ale.be.repository.JadwalRepository;
import com.rest.ale.be.repository.KelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnrollService {

    @Autowired
    AkunRepository akunRepo;

    @Autowired
    KelasRepository kelasRepo;

    @Autowired
    EnrollRepository enrollRepo;

    public List<Enroll> getAllEnrolls() {
        return enrollRepo.findAll();
    }


    public Optional<Enroll> getEnrollById(Long enrollId) {
        if (!akunRepo.existsById(enrollId)) {
            throw new ResourceTidakTersedia("Maaf, akun dengan id " + enrollId + " tidak ada");
        }
        return enrollRepo.findById(enrollId);
    }


    public Enroll createEnroll(Long idKelas, Long idAkun, Enroll enroll) {
        List<Kelas> kelass = new ArrayList<>();
        List<Akun> akuns = new ArrayList<>();
        List<Enroll> enrolls = new ArrayList<>();
        Kelas kelas = new Kelas();
        Akun akun = new Akun();

        Optional<Kelas> byId = kelasRepo.findById(idKelas);
        Optional<Akun> byusername = akunRepo.findById(idAkun);
        if (!byId.isPresent()) {
            throw new ResourceTidakTersedia("Maaf, kelas dengan id " + idKelas + " tidak ada");
        }
        Kelas ambilKelas = byId.get();
        Akun ambilAkun = byusername.get();

        //tie Kelas to Jadwal
        enroll.setFk_kelas(ambilKelas);
        enroll.setFk_akun(ambilAkun);



        Enroll enrollBaru = enrollRepo.save(enroll);
        //tie Jadwal to Kelas

        enrolls.add(enrollBaru);

        kelas.setEnroll(enrolls);
        akun.setEnroll(enrolls);

        return enrollBaru;

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
