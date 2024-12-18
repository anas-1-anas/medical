package com.softway.medical.service;

import com.softway.medical.exception.DiagnosisNotFoundException;
import com.softway.medical.repository.DiagnosisRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DiagnosisService implements DiagnosisRepository {

    private final DiagnosisRepository diagnosisRepository;

    public DiagnosisService(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    public List<String> determinePathologies(int healthIndex) {
        List<String> pathologies = new ArrayList<>();

        if (healthIndex % 3 == 0) {
            pathologies.add("Cardiologie");
        }

        if (healthIndex % 5 == 0) {
            pathologies.add("Traumatologie");
        }

        if (pathologies.isEmpty()) {
            throw new DiagnosisNotFoundException("No diagnosis found for health index " + healthIndex);
        }

        return pathologies;
    }
}


