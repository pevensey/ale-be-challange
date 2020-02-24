package com.rest.ale.be.controller;

import com.rest.ale.be.model.Jadwal;
import com.rest.ale.be.model.Kelas;
import com.rest.ale.be.repository.JadwalRepository;
import com.rest.ale.be.repository.KelasRepository;
import com.rest.ale.be.service.JadwalService;
import javassist.NotFoundException;
import org.hibernate.validator.internal.util.logging.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
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

    @Autowired
    JadwalService jadwalService;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Jadwal  ";
    }

    @GetMapping("/")
    public List<Jadwal> getAll(){
        return jadwalService.getAllJadwals();
    }

    @PostMapping("/baru")
    public Jadwal JadwalBaru(@Valid @RequestBody Jadwal jadwalBaru) {
//        Kelas cariKelas = jadwalBaru.getFk_kelas();
//        Optional<Kelas> kelas = kelasRepo.findById(cariKelas);
//        String result = "";
//
//        if (kelas.isPresent()) {
//            //return new ResponseEntity<>(HttpStatus.CONFLICT);
//            result = "Jadwal berhasil dibuat";
//            System.out.println(result);
           Kelas kelas = new Kelas();
           //kelas.setId_kelas(jadwalBaru.getFk_kelas());
           kelas.addJadwal(jadwalBaru);

//        EntityManager
//        EntityManager em = getEntityManager();
//            entityManager.persist(kelas);
            kelasRepo.persist(kelas);
        return jadwalRepo.save(jadwalBaru);
//        } else {
//            result = "Maaf, kelas tidak ada";
//        }
//        return result;
    }
    //Book
    @RequestMapping(value = "/{idKelas}/jadwal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Jadwal createBook(@PathVariable(value = "idKelas") Long idKelas, @RequestBody Jadwal jadwal) {
        return jadwalService.createJadwal(idKelas, jadwal);
    }

    @RequestMapping(value = "/jadwal/{idJadwal}", method = RequestMethod.GET)
    public Optional<Jadwal> getBookById(@PathVariable(value = "idJadwal") Long idJadwal) {
        return jadwalService.getJadwalById(idJadwal);
    }
}
