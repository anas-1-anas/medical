package com.softway.medical.service;

import com.softway.medical.exception.DiagnosisNotFoundException;
import com.softway.medical.service.impl.DiagnosisServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiagnosisServiceImplTest {

    private DiagnosisServiceImpl diagnosisServiceImpl;

    @BeforeEach
    public void setUp() {
        diagnosisServiceImpl = new DiagnosisServiceImpl();
    }

    @Test
    public void testCardiologieOk() {
        List<String> result = diagnosisServiceImpl.identifyPathology(27);

        assertEquals(Arrays.asList("Cardiologie"), result);
    }


    @Test
    public void testTraumatologieOk() {
        List<String> result = diagnosisServiceImpl.identifyPathology(50);

        assertEquals(Arrays.asList("Traumatologie"), result);
    }


    @Test
    public void testCardiologieAndTraumatologieOk() {
        List<String> result = diagnosisServiceImpl.identifyPathology(15);

        assertEquals(Arrays.asList("Cardiologie Traumatologie"), result);
    }

    @Test
    public void testCardiologieAndTraumatologieKo() {
        Exception exception = assertThrows(DiagnosisNotFoundException.class, () -> {
            diagnosisServiceImpl.identifyPathology(11);
        });

        assertEquals("Diagnosis not found", exception.getMessage());
    }
}


