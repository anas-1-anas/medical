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
        List<String> result = diagnosisService.determinePathologies(27);

        assertEquals(Arrays.asList("Cardiologie"), result);
    }


    @Test
    public void testTraumatologieOk() {
        List<String> result = diagnosisService.determinePathologies(50);

        assertEquals(Arrays.asList("Traumatologie"), result);
    }


    @Test
    public void testCardiologieAndTraumatologieOk() {
        List<String> result = diagnosisService.determinePathologies(15);

        assertEquals(Arrays.asList("Cardiologie", "Traumatologie"), result);
    }

    @Test
    public void testCardiologieAndTraumatologieKo() {
        Exception exception = assertThrows(DiagnosisNotFoundException.class, () -> {
            diagnosisService.determinePathologies(11);
        });

        assertEquals("No diagnosis found for health index 11", exception.getMessage());
    }
}





