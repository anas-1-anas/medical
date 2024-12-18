package com.softway.medical.controller;


import com.softway.medical.exception.DiagnosisNotFoundException;
import com.softway.medical.service.DiagnosisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    public DiagnosisController(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @GetMapping("/diagnosis/{index}")
    public ResponseEntity<List<String>> getDiagnosis(@PathVariable int index) {

        List<String> pathologies = diagnosisService.identifyPathology(index);

        return ResponseEntity.ok(pathologies);
    }

    @ExceptionHandler(DiagnosisNotFoundException.class)
    public ResponseEntity<String> handleDiagnosisNotFound(DiagnosisNotFoundException ex) {

        return ResponseEntity.status(404).body(ex.getMessage());
    }
}

