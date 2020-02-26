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
            throw new ResourceTidakTersedia("Maaf, akun dengan id " + AkunId + " tidak ada");
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

    public Akun updateAkunById(Long akunId, Akun akunRequest) {
        if (!akunRepo.existsById(akunId)) {
            throw new ResourceTidakTersedia("Akun dengan id " + akunId + "tidak ada");
        }
        Optional<Akun> akun = akunRepo.findById(akunId);

        if (!akun.isPresent()) {
            throw new ResourceTidakTersedia("Akun dengan id " + akunId + " tidak ada");
        }

        Akun akunBaru = akun.get();
        akunBaru.setNama(akunRequest.getNama());
        akunBaru.setPassword(akunRequest.getPassword());

        return akunRepo.save(akunBaru);
    }

    public String deleteAkunById(Long AkunId) {
        if (!akunRepo.existsById(AkunId)) {
            throw new ResourceTidakTersedia("Akun dengan id " + AkunId + " tidak ada");
        }

        akunRepo.deleteById(AkunId);

        return "akun dengan id "+AkunId+" berhasil di hapus";

    }

}
