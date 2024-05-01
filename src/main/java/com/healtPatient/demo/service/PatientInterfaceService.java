package com.healtPatient.demo.service;

import com.healtPatient.demo.persistence.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientInterfaceService {

    List<Patient> getAll();

    Optional<Patient> getById(int patientIdDto);

    Patient  save (Patient patient);

    Patient update (Patient patient, int patientIdDto);

    void delete(int patientIdDto);
}
