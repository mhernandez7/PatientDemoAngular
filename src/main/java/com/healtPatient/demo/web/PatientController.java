package com.healtPatient.demo.web;

import com.healtPatient.demo.persistence.entity.Patient;
import com.healtPatient.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patientDemo")
public class PatientController {

    @Autowired
    private PatientService service;

    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAll(){

        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);

    }
    @GetMapping("/{patientIdDto}")
    public ResponseEntity<Patient> getById(@PathVariable int patientIdDto){
       return service.getById(patientIdDto).map(patient -> new ResponseEntity(patient, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @PostMapping("/save")
    public ResponseEntity<Patient> save (@RequestBody Patient  patient){

        return new ResponseEntity<>(service.save(patient), HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @PutMapping("/update/{patientIdDto}")
    public ResponseEntity<Patient> update(@RequestBody Patient patient, @PathVariable int patientIdDto){

        if(service.getById(patientIdDto).isPresent()){
            return new ResponseEntity<>(service.update(patient, patientIdDto), HttpStatus.OK );
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @CrossOrigin(origins = "http://localhost:4200/")
    @DeleteMapping("/delete/{patientIdDto}")
    public ResponseEntity<Patient> delete (@PathVariable int patientIdDto ){

        if(service.getById(patientIdDto).isPresent()){
            service.delete(patientIdDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
