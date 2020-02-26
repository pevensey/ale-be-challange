package com.rest.ale.be.controller;

import com.rest.ale.be.exception.ResourceTidakTersedia;
import com.rest.ale.be.model.Akun;
import com.rest.ale.be.repository.AkunRepository;
import java.util.List;

import com.rest.ale.be.service.AkunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(path="/akun" )
public class AkunController {

    @Autowired
    private AkunService akunService;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Akun  ";
    }

    @GetMapping("/")
    public List<Akun> getAll(){
        return akunService.getAllAkuns();
    }

    @PostMapping("/baru")
    public Akun signUp(@Valid @RequestBody Akun penggunaBaru) {
        String username = penggunaBaru.getUsername();
        return akunService.createAkun(username, penggunaBaru);
    }
}
