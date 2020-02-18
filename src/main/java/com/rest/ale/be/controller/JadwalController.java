package com.rest.ale.be.controller;

import com.rest.ale.be.model.Jadwal;
import com.rest.ale.be.repository.JadwalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/jadwal" )
public class JadwalController {
    @Autowired

    private JadwalRepository jadwalRepo;


    @RequestMapping("/hello")
    public String hello(){
        return "Hello Jadwal  ";
    }

    @GetMapping("/")
    public List<Jadwal> getAll(){
        return (List<Jadwal>) jadwalRepo.findAll();
    }

    @PostMapping("/baru")
    public Jadwal JadwalBaru(@Valid @RequestBody Jadwal jadwalBaru) {
        return jadwalRepo.save(jadwalBaru);
    }
}
