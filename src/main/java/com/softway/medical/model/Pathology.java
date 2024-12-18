package com.softway.medical.model;

public enum Pathology {

    CARDIOLOGIE("Cardiologie"),
    TRAUMATOLOIE("Traumatologie");

    private final String name;

    Pathology(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
