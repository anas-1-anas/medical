package com.softway.medical;


import com.softway.medical.exception.DiagnosisNotFoundException;
import com.softway.medical.service.DiagnosisService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MedicalApplicationTests {

    private DiagnosisService diagnosisService;

    @BeforeEach
    public void setUp() {
        diagnosisService = new DiagnosisService(null);
    }

    @Test
    public void testCardiologieOk() {
        List<String> result = diagnosisService.identifyPathology(27);

        assertEquals(Arrays.asList("Cardiologie"), result);
    }


    @Test
    public void testTraumatologieOk() {
        List<String> result = diagnosisService.identifyPathology(50);

        assertEquals(Arrays.asList("Traumatologie"), result);
    }


    @Test
    public void testCardiologieAndTraumatologieOk() {
        List<String> result = diagnosisService.identifyPathology(15);

        assertEquals(Arrays.asList("Cardiologie", "Traumatologie"), result);
    }

    @Test
    public void testCardiologieAndTraumatologieKo() {
        Exception exception = assertThrows(DiagnosisNotFoundException.class, () -> {
            diagnosisService.identifyPathology(11);
        });

        assertEquals("Diagnosis not found", exception.getMessage());
    }
}





