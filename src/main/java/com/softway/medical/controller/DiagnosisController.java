package com.softway.medical.controller;


import com.softway.medical.exception.DiagnosisNotFoundException;
import com.softway.medical.service.impl.DiagnosisServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiagnosisController {

    private final DiagnosisServiceImpl diagnosisServiceImpl;

    public DiagnosisController(DiagnosisServiceImpl diagnosisServiceImpl) {
        this.diagnosisServiceImpl = diagnosisServiceImpl;
    }

    @GetMapping("/diagnosis/{index}")
    public ResponseEntity<List<String>> getDiagnosis(@PathVariable int index) {

        List<String> pathologies = diagnosisServiceImpl.identifyPathology(index);

        return ResponseEntity.ok(pathologies);
    }

    @ExceptionHandler(DiagnosisNotFoundException.class)
    public ResponseEntity<String> handleDiagnosisNotFound(DiagnosisNotFoundException ex) {

        return ResponseEntity.status(404).body(ex.getMessage());
    }
}

