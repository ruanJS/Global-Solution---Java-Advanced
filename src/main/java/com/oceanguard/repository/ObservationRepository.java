package com.oceanguard.repository;

import com.oceanguard.models.Observation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservationRepository extends JpaRepository<Observation, Long> {
    // Métodos de consulta personalizados, se necessário
}
