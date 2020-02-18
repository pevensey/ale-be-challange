package com.rest.ale.be.controller;

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

//    @PostMapping("/tambah")
//    public Akun tambahAkun(@Valid @RequestBody Akun akun) {
//        return akunRepo.save(akun);
//    }

    @PostMapping("/baru")
    public String signUp(@Valid @RequestBody Akun penggunaBaru) {
        String username = penggunaBaru.getUsername();
        String peran = penggunaBaru.getRole();

        Akun akun = akunRepo.findByUsername(username);
        String result = "";
        if (akun!=null) {
            //return new ResponseEntity<>(HttpStatus.CONFLICT);
            result = "Maaf, akun sudah ada";
            return result ;
        } else {
            //pengguna.setPassword(bCryptPasswordEncoder.encode(pengguna.getPassword()));
            if (peran.equals("mahasiswa")){
                penggunaBaru.setRole("mahasiswa");
            } else if(peran.equals("Mahasiswa")){
                penggunaBaru.setRole("Mahasiswa");
            } else if(peran.equals("Dosen")){
                penggunaBaru.setRole("Dosen");
            } else if(peran.equals("dosen")){
                penggunaBaru.setRole("dosen");
            } else{
                return "Maaf, role yang di isi salah";
            }

            akunRepo.save(penggunaBaru);
            //return new ResponseEntity<>(HttpStatus.CREATED);
            result = "akun berhasil dibuat";
            return result ;
        }
    }
}
