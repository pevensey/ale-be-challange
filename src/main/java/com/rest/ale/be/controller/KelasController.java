package com.rest.ale.be.controller;

import com.rest.ale.be.model.Kelas;
import com.rest.ale.be.service.KelasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/kelas" )
public class KelasController {

    @Autowired
    private KelasService kelasService;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Kelas  ";
    }

    @GetMapping("/")
    public List<Kelas> getAll(){
        return kelasService.getAllKelas();
    }
    @GetMapping("/{id}")
    public Optional<Kelas> getKelasById(@PathVariable(value="id") Long id){
        return kelasService.getKelasById(id);
    }
    @PostMapping("/baru")
    public Kelas kelasBaru(@Valid @RequestBody Kelas kelasBaru) {
        return kelasService.createKelas(kelasBaru);
    }
    
    @RequestMapping(value = "/{idKelas}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Kelas updateKelas(@PathVariable(value = "idKelas") Long kelasId, @RequestBody Kelas kelas) {

        return kelasService.updateKelasById(kelasId, kelas );
    }

    @RequestMapping(value = "/{idKelas}", method = RequestMethod.DELETE)
    public String deleteKelasById(@PathVariable(value = "idKelas") Long kelasId) {
        return kelasService.deleteKelasById(kelasId);
    }
}
