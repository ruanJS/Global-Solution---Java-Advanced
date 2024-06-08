package com.oceanguard.data;

import org.springframework.stereotype.Component;

@Component
public class DataProcessor {

    public String process(String rawData) {
        System.out.println("Processando dados...");
        return "dados processados";
    }
}
