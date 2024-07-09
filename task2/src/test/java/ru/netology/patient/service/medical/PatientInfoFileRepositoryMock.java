package ru.netology.patient.service.medical;

import ru.netology.patient.entity.BloodPressure;
import ru.netology.patient.entity.HealthInfo;
import ru.netology.patient.entity.PatientInfo;
import ru.netology.patient.repository.PatientInfoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PatientInfoFileRepositoryMock implements PatientInfoRepository {
    PatientInfo patientInfo = new PatientInfo("1","Иван", "Петров", LocalDate.of(1980, 11, 26),
            new HealthInfo(new BigDecimal("36.65"), new BloodPressure(120, 80)));
    @Override
    public PatientInfo getById(String id) {
        return patientInfo;
    }

    @Override
    public String add(PatientInfo patientInfo) {
        return null;
    }

    @Override
    public PatientInfo remove(String id) {
        return null;
    }

    @Override
    public PatientInfo update(PatientInfo patientInfo) {
        return null;
    }
}
