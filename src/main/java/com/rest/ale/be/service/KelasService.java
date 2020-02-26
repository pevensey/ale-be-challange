package com.rest.ale.be.service;

import com.rest.ale.be.model.Kelas;
import com.rest.ale.be.repository.KelasRepository;
import com.rest.ale.be.exception.ResourceTidakTersedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KelasService {
    @Autowired
    KelasRepository kelasRepo;

    public List<Kelas> getAllKelas() {
        return kelasRepo.findAll();
    }


    public Optional<Kelas> getKelasById(Long id_kelas) {
        if (!kelasRepo.existsById(id_kelas)) {
            throw new ResourceTidakTersedia("Maaf, kelas dengan id " + id_kelas + " tidak ada");
        }
        return kelasRepo.findById(id_kelas);
    }


    public Kelas createKelas(Kelas kelas) {
        return kelasRepo.save(kelas);

    }

    public Kelas updateKelasById(Long kelasId, Kelas kelasRequest) {
        if (!kelasRepo.existsById(kelasId)) {
            throw new ResourceTidakTersedia("Kelas with id " + kelasId + " not found");
        }
        Optional<Kelas> kelas = kelasRepo.findById(kelasId);

        if (!kelas.isPresent()) {
            throw new ResourceTidakTersedia("Kelas dengan id " + kelasId + " tidak ada");
        }

        Kelas kelasBaru = kelas.get();
        kelasBaru.setMatkul(kelasRequest.getMatkul());
        kelasBaru.setDosen(kelasRequest.getDosen());

        return kelasRepo.save(kelasBaru);
    }

    public String deleteKelasById(Long KelasId) {
        if (!kelasRepo.existsById(KelasId)) {
            throw new ResourceTidakTersedia("Kelas dengan id " + KelasId + " tidak ada");
        }

        kelasRepo.deleteById(KelasId);

        return "Kelas dengan id "+KelasId+" berhasil di hapus";

    }
}
