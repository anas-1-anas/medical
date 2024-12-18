package com.softway.medical.repository;

import java.util.List;

public interface DiagnosisRepository {
    List<String> determinePathologies(int healthIndex);
}
