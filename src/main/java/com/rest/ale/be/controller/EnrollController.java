package com.rest.ale.be.controller;

import com.rest.ale.be.model.Enroll;
import com.rest.ale.be.service.EnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/enroll" )
public class EnrollController {

    @Autowired
    EnrollService enrollService;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Enroll  ";
    }

    @GetMapping("/")
    public List<Enroll> getAll(){
        return enrollService.getAllEnrolls();
    }


    @RequestMapping(value = "/baru/{idKelas}/{idAkun}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Enroll createEnroll(@PathVariable(value = "idKelas") Long idKelas, @PathVariable(value = "idAkun")Long idAkun, @RequestBody Enroll enroll) {
        return enrollService.createEnroll(idKelas, idAkun, enroll);
    }

    @RequestMapping(value = "/{idEnroll}", method = RequestMethod.GET)
    public Optional<Enroll> getEnrollById(@PathVariable(value = "idEnroll") Long idEnroll) {
        return enrollService.getEnrollById(idEnroll);
    }

    @RequestMapping(value = "/{idEnroll}", method = RequestMethod.DELETE)
    public String deleteEnrollById(@PathVariable(value = "idEnroll") Long enrollId) {
        return enrollService.deleteEnrollById(enrollId);
    }
}
