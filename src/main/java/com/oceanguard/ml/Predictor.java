package com.oceanguard.ml;

import org.springframework.stereotype.Component;

@Component
public class Predictor {

    public String predict(String processedData) {
        System.out.println("Prevendo mudanças futuras...");
        return "mudanças previstas";
    }
}


