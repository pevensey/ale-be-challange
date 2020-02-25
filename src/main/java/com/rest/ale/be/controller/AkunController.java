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
        String peran = penggunaBaru.getRole();

        Akun akun = akunRepo.findByUsername(username);

        if (akun!=null) {
            //return new ResponseEntity<>(HttpStatus.CONFLICT);
            throw new ResourceTidakTersedia("Maaf, username sudah digunakan");
        } else {
            //pengguna.setPassword(bCryptPasswordEncoder.encode(pengguna.getPassword()));
            if (peran.equals("mahasiswa")){
                penggunaBaru.setRole("Mahasiswa");
            }
            else if(peran.equals("Mahasiswa")){
                penggunaBaru.setRole("Mahasiswa");
            }
            else if(peran.equals("Dosen")){
                penggunaBaru.setRole("Dosen");
            }
            else if(peran.equals("dosen")){
                penggunaBaru.setRole("Dosen");
            }
            else{
                    throw new ResourceTidakTersedia("Maaf, role yang di isi salah. Role harus mahasiswa atau dosen");
            }

            return akunRepo.save(penggunaBaru);
        }
    }
}
