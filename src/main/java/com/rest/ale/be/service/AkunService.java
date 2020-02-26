package com.rest.ale.be.service;

import com.rest.ale.be.exception.ResourceTidakTersedia;
import com.rest.ale.be.model.Akun;
import com.rest.ale.be.repository.AkunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AkunService {
    @Autowired
    AkunRepository akunRepo;

    public List<Akun> getAllAkuns() {
        return akunRepo.findAll();
    }


    public Optional<Akun> getAkunById(Long AkunId) {
        if (!akunRepo.existsById(AkunId)) {
            throw new ResourceTidakTersedia("Maaf, jadwal dengan id " + AkunId + " tidak ada");
        }
        return akunRepo.findById(AkunId);
    }


    public Akun createAkun(String username, Akun akun) {

        Akun cariUsername = akunRepo.findByUsername(username);

        if (cariUsername!=null) {
            throw new ResourceTidakTersedia("Maaf, username sudah digunakan");
        } else {
            akunRepo.save(akun);
        }

        return akun;

    }

//    public Akun updateAkunById(Long jadwalId, Akun jadwalRequest) {
//        if (!akunRepo.existsById(jadwalId)) {
//            throw new ResourceTidakTersedia("Akun with id " + jadwalId + " not found");
//        }
//        Optional<Akun> jadwal = akunRepo.findById(jadwalId);
//
//        if (!jadwal.isPresent()) {
//            throw new ResourceTidakTersedia("Akun dengan id " + jadwalId + " tidak ada");
//        }
//
//        Akun jadwalBaru = jadwal.get();
//        jadwalBaru.setHari(jadwalRequest.getHari());
//        jadwalBaru.setJam(jadwalRequest.getJam());
//        jadwalBaru.setRuang(jadwalRequest.getRuang());
//
//        return akunRepo.save(jadwalBaru);
//    }
//
//    public String deleteAkunById(Long AkunId) {
//        if (!akunRepo.existsById(AkunId)) {
//            throw new ResourceTidakTersedia("Akun dengan id " + AkunId + " tidak ada");
//        }
//
//        akunRepo.deleteById(AkunId);
//
//        return "jadwal dengan id "+AkunId+" berhasil di hapus";
//
//    }

}
