package com.rest.ale.be.controller;

import com.rest.ale.be.model.Kelas;
import com.rest.ale.be.repository.KelasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/kelas" )
public class KelasController {
    @Autowired

    private KelasRepository kelasRepo;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Kelas  ";
    }

    @GetMapping("/")
    public List<Kelas> getAll(){
        return (List<Kelas>) kelasRepo.findAll();
    }

    @PostMapping("/baru")
    public Kelas kelasBaru(@Valid @RequestBody Kelas kelasBaru) {
        return kelasRepo.save(kelasBaru);
    }

}
