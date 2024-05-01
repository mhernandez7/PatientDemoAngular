package com.healtPatient.demo.service;

import com.healtPatient.demo.persistence.crud.PatientCrudRepository;
import com.healtPatient.demo.persistence.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements PatientInterfaceService{

    @Autowired
    private PatientCrudRepository patientCrudRepository;

    @Override
    public List<Patient> getAll() {
        List<Patient> patients = (List<Patient>) patientCrudRepository.findAll();
        return patients;
    }

    @Override
    public Optional<Patient> getById(int patientIdDto) {

        return patientCrudRepository.findById(patientIdDto);
    }

    @Override
    public Patient save(Patient patient) {

        return patientCrudRepository.save(patient);
    }

    @Override
    public Patient update(Patient patient, int patientIdDto) {
        patientCrudRepository.findById(patientIdDto).map(patient1 -> {

            patient.setFirstNameDto(patient.getFirstNameDto());
            patient.setLastNameDto(patient.getLastNameDto());
            patient.setAdressDto(patient.getAdressDto());
            patient.setHospitalIdDto(patient.getHospitalIdDto());
            patient.setCityDto(patient.getCityDto());
           return patient1 = patientCrudRepository.save(patient);
        }).get();
        return null;
    }

    @Override
    public void delete(int patientIdDto) {
        String msj="";
        if(patientCrudRepository.findById(patientIdDto).isPresent()){
            patientCrudRepository.deleteById(patientIdDto);
        }
    }

}
