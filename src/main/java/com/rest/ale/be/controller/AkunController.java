package com.rest.ale.be.controller;

import com.rest.ale.be.model.Akun;
import com.rest.ale.be.repository.AkunRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/akun" )
public class AkunController {
    @Autowired

    private AkunRepository akunRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AkunController(AkunRepository akunRepo,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.akunRepo = akunRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Akun  ";
    }

    @GetMapping("/")
    public List<Akun> getAll(){
        return akunRepo.findAll();
    }

//    @PostMapping("/tambah")
//    public Akun tambahAkun(@Valid @RequestBody Akun akun) {
//        return akunRepo.save(akun);
//    }

    @PostMapping("/sign-up")
    public String signUp(@RequestBody Akun pengguna) {
        String username = pengguna.getUsername();
        Akun akun = akunRepo.findByUsername(username);
        String result = "";
        if (akun!=null) {
            //return new ResponseEntity<>(HttpStatus.CONFLICT);
            result = "akun sudah ada";
            return result ;
        } else {
            pengguna.setPassword(bCryptPasswordEncoder.encode(pengguna.getPassword()));
            akunRepo.save(pengguna);
            //return new ResponseEntity<>(HttpStatus.CREATED);
            result = "akun berhasil dibuat";
            return result ;
        }
    }
}
