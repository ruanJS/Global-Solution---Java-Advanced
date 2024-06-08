package com.oceanguard.ml;

import org.springframework.stereotype.Component;

@Component
public class AnomalyDetector {

    public String detect(String processedData) {
        System.out.println("Detectando anomalias...");
        return "anomalias detectadas";
    }
}
