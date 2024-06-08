package com.oceanguard.service.impl;

import com.oceanguard.models.Observation;
import com.oceanguard.repository.ObservationRepository;
import com.oceanguard.service.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservationServiceImpl extends ObservationService {

    private final ObservationRepository observationRepository;

    @Autowired
    public ObservationServiceImpl(ObservationRepository observationRepository) {
        this.observationRepository = observationRepository;
    }

    @Override
    public void saveObservation(Observation observation) {
        observationRepository.save(observation);
    }
}
