package com.oceanguard.integration;

import org.springframework.stereotype.Component;

@Component
public class ApiIntegrator {

    public void integrateData(String apiData) {
        System.out.println("Integrando dados da API: " + apiData);
    }
}


