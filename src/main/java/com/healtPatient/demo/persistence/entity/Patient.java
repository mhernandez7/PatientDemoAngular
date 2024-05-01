package com.healtPatient.demo.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer patientIdDto;

    @Column(name = "first_name")
    private String firstNameDto;
    @Column(name = "last_name")
    private String lastNameDto;
    @Column(name = "adress")
    private String adressDto;
    @Column(name = "hospital_Id")
    private Integer hospitalIdDto;
    @Column(name = "city")
    private String cityDto;

    public Integer getPatientIdDto() {
        return patientIdDto;
    }

    public void setPatientIdDto(Integer patientIdDto) {
        this.patientIdDto = patientIdDto;
    }

    public String getFirstNameDto() {
        return firstNameDto;
    }

    public void setFirstNameDto(String firstNameDto) {
        this.firstNameDto = firstNameDto;
    }

    public String getLastNameDto() {
        return lastNameDto;
    }

    public void setLastNameDto(String lastNameDto) {
        this.lastNameDto = lastNameDto;
    }

    public String getAdressDto() {
        return adressDto;
    }

    public void setAdressDto(String adressDto) {
        this.adressDto = adressDto;
    }


    public Integer getHospitalIdDto() {
        return hospitalIdDto;
    }

    public void setHospitalIdDto(Integer hospitalIdDto) {
        this.hospitalIdDto = hospitalIdDto;
    }

    public String getCityDto() {
        return cityDto;
    }

    public void setCityDto(String cityDto) {
        this.cityDto = cityDto;
    }
}
