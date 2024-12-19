package com.softway.medical.service.impl;

import com.softway.medical.exception.DiagnosisNotFoundException;
import com.softway.medical.service.DiagnosisService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class DiagnosisServiceImpl implements DiagnosisService {


    public DiagnosisServiceImpl() {
    }

    public List<String> identifyPathology(int index) {
        StringBuilder result = new StringBuilder();


        if (index % 3 == 0) {
            result.append("Cardiologie").append(" ");
        }

        if (index % 5 == 0) {
            result.append("Traumatologie").append(" ");
        }

        if (result.length() == 0) {
            throw new DiagnosisNotFoundException("Diagnosis not found");
        }

        if (result.length() > 0) {
            result.deleteCharAt(result.length() - 1);
        }

        return Collections.singletonList(result.toString());
    }
}


