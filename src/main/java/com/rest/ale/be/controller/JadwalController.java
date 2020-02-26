package com.rest.ale.be.controller;

import com.rest.ale.be.model.Jadwal;
import com.rest.ale.be.repository.JadwalRepository;
import com.rest.ale.be.repository.KelasRepository;
import com.rest.ale.be.service.JadwalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path="/jadwal" )
public class JadwalController {

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
    public Jadwal createJadwal(@PathVariable(value = "idKelas") Long idKelas, @RequestBody Jadwal jadwal) {
        String hari = jadwal.getHari();
        String cekHari= jadwalService.cekHari(hari);
        jadwal.setHari(cekHari);
        return jadwalService.createJadwal(idKelas, jadwal);
    }

    @RequestMapping(value = "/{idJadwal}", method = RequestMethod.GET)
    public Optional<Jadwal> getJadwalById(@PathVariable(value = "idJadwal") Long idJadwal) {
        return jadwalService.getJadwalById(idJadwal);
    }

    @RequestMapping(value = "/{idJadwal}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Jadwal updateJadwal(@PathVariable(value = "idJadwal") Long jadwalId, @RequestBody Jadwal jadwal) {
        String hari = jadwal.getHari();
        String cekHari= jadwalService.cekHari(hari);
        jadwal.setHari(cekHari);
        return jadwalService.updateJadwalById(jadwalId, jadwal );
    }

    @RequestMapping(value = "/{idJadwal}", method = RequestMethod.DELETE)
    public String deleteJadwalById(@PathVariable(value = "idJadwal") Long jadwalId) {
        return jadwalService.deleteJadwalById(jadwalId);
    }

}
