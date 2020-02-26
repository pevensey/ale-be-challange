package com.rest.ale.be.service;

import com.rest.ale.be.exception.ResourceTidakTersedia;
import com.rest.ale.be.model.Jadwal;
import com.rest.ale.be.model.Kelas;
import com.rest.ale.be.repository.JadwalRepository;
import com.rest.ale.be.repository.KelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;
import java.util.*;

@Service
public class JadwalService {


    @Autowired
    JadwalRepository jadwalRepo;

    @Autowired
    KelasRepository kelasRepo;

    public List<Jadwal> getAllJadwals() {
        return jadwalRepo.findAll();
    }


    public Optional<Jadwal> getJadwalById(Long JadwalId) {
        if (!jadwalRepo.existsById(JadwalId)) {
            throw new ResourceTidakTersedia("Maaf, jadwal dengan id " + JadwalId + " tidak ada");
        }
        return jadwalRepo.findById(JadwalId);
    }


    public Jadwal createJadwal(Long idKelas, Jadwal jadwal) {
        List<Jadwal> jadwals = new ArrayList<>();
        Kelas kelas = new Kelas();

        String ruang = jadwal.getRuang();
        String hari = jadwal.getHari();
        LocalTime jam = jadwal.getJam();
        Jadwal cariRuangHariJam = jadwalRepo.findByRuangAndHariAndJam(ruang, hari ,jam);
        Optional<Kelas> byId = kelasRepo.findById(idKelas);
        if (!byId.isPresent()) {
            throw new ResourceTidakTersedia("Maaf, kelas dengan id " + idKelas + " tidak ada");
        }
        if (cariRuangHariJam!=null){
            throw new ResourceTidakTersedia("Maaf, ruangan sudah digunakan pada hari dan jam tersebut");
        }
        Kelas ambilKelas = byId.get();

        //tie Kelas to Jadwal
        jadwal.setFk_kelas(ambilKelas);

        Jadwal jadwalBaru = jadwalRepo.save(jadwal);
        //tie Jadwal to Kelas
        jadwals.add(jadwalBaru);
        kelas.setJadwals(jadwals);

        return jadwalBaru;

    }

    public Jadwal updateJadwalById(Long jadwalId, Jadwal jadwalRequest) {
        if (!jadwalRepo.existsById(jadwalId)) {
            throw new ResourceTidakTersedia("Jadwal with id " + jadwalId + " not found");
        }
        Optional<Jadwal> jadwal = jadwalRepo.findById(jadwalId);

        if (!jadwal.isPresent()) {
            throw new ResourceTidakTersedia("Jadwal dengan id " + jadwalId + " tidak ada");
        }

        Jadwal jadwalBaru = jadwal.get();
        jadwalBaru.setHari(jadwalRequest.getHari());
        jadwalBaru.setJam(jadwalRequest.getJam());
        jadwalBaru.setRuang(jadwalRequest.getRuang());

        return jadwalRepo.save(jadwalBaru);
    }

    public String deleteJadwalById(Long JadwalId) {
        if (!jadwalRepo.existsById(JadwalId)) {
            throw new ResourceTidakTersedia("Jadwal dengan id " + JadwalId + " tidak ada");
        }

        jadwalRepo.deleteById(JadwalId);

        return "jadwal dengan id "+JadwalId+" berhasil di hapus";

    }
}
