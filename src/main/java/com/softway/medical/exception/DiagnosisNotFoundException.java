package com.softway.medical.exception;


public class DiagnosisNotFoundException extends RuntimeException {
    public DiagnosisNotFoundException(String message) {
        super(message);
    }
}

