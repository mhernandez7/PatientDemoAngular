package com.healtPatient.demo.persistence.crud;

import com.healtPatient.demo.persistence.entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientCrudRepository extends CrudRepository<Patient, Integer> {
}
