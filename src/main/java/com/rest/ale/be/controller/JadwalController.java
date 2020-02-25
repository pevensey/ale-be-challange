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


    @RequestMapping(value = "/baru/{idKelas}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Jadwal createBook(@PathVariable(value = "idKelas") Long idKelas, @RequestBody Jadwal jadwal) {
        return jadwalService.createJadwal(idKelas, jadwal);
    }

    @RequestMapping(value = "/{idJadwal}", method = RequestMethod.GET)
    public Optional<Jadwal> getBookById(@PathVariable(value = "idJadwal") Long idJadwal) {
        return jadwalService.getJadwalById(idJadwal);
    }
}
