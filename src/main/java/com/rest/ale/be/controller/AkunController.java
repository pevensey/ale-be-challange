package com.rest.ale.be.controller;

import com.rest.ale.be.exception.ResourceTidakTersedia;
import com.rest.ale.be.model.Akun;
import com.rest.ale.be.repository.AkunRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(path="/akun" )
public class AkunController {
    @Autowired

    private AkunRepository akunRepo;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Akun  ";
    }

    @GetMapping("/")
    public List<Akun> getAll(){
        return akunRepo.findAll();
    }

    @PostMapping("/baru")
    public Akun signUp(@Valid @RequestBody Akun penggunaBaru) {
        String username = penggunaBaru.getUsername();

        Akun akun = akunRepo.findByUsername(username);

        if (akun!=null) {
            throw new ResourceTidakTersedia("Maaf, username sudah digunakan");
        } else {
            return akunRepo.save(penggunaBaru);
        }
    }
}
