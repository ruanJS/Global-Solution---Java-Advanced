package com.oceanguard.data;

import org.springframework.stereotype.Component;

@Component
public class DataFetcher {

    public String fetchData() {
        System.out.println("Buscando dados...");
        return "dados brutos";
    }
}

