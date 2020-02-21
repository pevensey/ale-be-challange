package com.rest.ale.be.controller;

import com.rest.ale.be.model.Jadwal;
import com.rest.ale.be.model.Kelas;
import com.rest.ale.be.repository.JadwalRepository;
import com.rest.ale.be.repository.KelasRepository;
import javassist.NotFoundException;
import org.hibernate.validator.internal.util.logging.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping(path="/jadwal" )
public class JadwalController {
    @Autowired

    private JadwalRepository jadwalRepo;
    @Autowired
    private KelasRepository kelasRepo;


    @RequestMapping("/hello")
    public String hello(){
        return "Hello Jadwal  ";
    }

    @GetMapping("/")
    public List<Jadwal> getAll(){
        return jadwalRepo.findAll();
    }

    @PostMapping("/baru")
    public String JadwalBaru(@Valid @RequestBody Jadwal jadwalBaru) {
        Long cariKelas = jadwalBaru.getFk_kelas();
        Optional<Kelas> kelas = kelasRepo.findById(cariKelas);
        String result = "";

        if (kelas.isPresent()) {
            //return new ResponseEntity<>(HttpStatus.CONFLICT);
            result = "Kelas sudah ada";
            System.out.println(result);
            jadwalRepo.save(jadwalBaru);
        } else {
            result = "Maaf, kelas tidak ada";
        }
        return result;
    }
}
