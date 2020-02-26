package com.rest.ale.be.controller;

import com.rest.ale.be.model.Akun;
import java.util.List;
import java.util.Optional;

import com.rest.ale.be.repository.AkunRepository;
import com.rest.ale.be.service.AkunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(path="/akun" )
public class AkunController {

    @Autowired
    private AkunService akunService;
    @Autowired
    private AkunRepository akunRepo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Akun  ";
    }

    @GetMapping("/")
    public List<Akun> getAll() {
        return akunService.getAllAkuns();
    }

    @PostMapping("/baru")
    public Akun signUp(@Valid @RequestBody Akun penggunaBaru) {
        String username = penggunaBaru.getUsername();
        penggunaBaru.setPassword(bCryptPasswordEncoder.encode(penggunaBaru.getPassword()));
        return akunService.createAkun(username, penggunaBaru);
    }

    @RequestMapping(value = "/{idAkun}", method = RequestMethod.GET)
    public Optional<Akun> getAkunById(@PathVariable(value = "idAkun") Long idAkun) {
        return akunService.getAkunById(idAkun);
    }

    @RequestMapping(value = "/{idAkun}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Akun updateAkun(@PathVariable(value = "idAkun") Long jadwalId, @RequestBody Akun jadwal) {

        return akunService.updateAkunById(jadwalId, jadwal);
    }

    @RequestMapping(value = "/{idAkun}", method = RequestMethod.DELETE)
    public String deleteAkunById(@PathVariable(value = "idAkun") Long jadwalId) {
        return akunService.deleteAkunById(jadwalId);
    }

//    public AkunController(AkunService akunService,
//                          BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.akunService = akunService;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
    public AkunController(AkunRepository akunRepo,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.akunRepo = akunRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
}
