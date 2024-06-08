package com.oceanguard;

import com.oceanguard.data.DataFetcher;
import com.oceanguard.data.DataProcessor;
import com.oceanguard.integration.ApiIntegrator;
import com.oceanguard.ml.AnomalyDetector;
import com.oceanguard.ml.Predictor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OceanGuardAnalyticsEngine implements CommandLineRunner {

	private final DataFetcher dataFetcher;
	private final DataProcessor dataProcessor;
	private final ApiIntegrator apiIntegrator;
	private final AnomalyDetector anomalyDetector;
	private final Predictor predictor;

	@Autowired
	public OceanGuardAnalyticsEngine(DataFetcher dataFetcher, DataProcessor dataProcessor, ApiIntegrator apiIntegrator, AnomalyDetector anomalyDetector, Predictor predictor) {
		this.dataFetcher = dataFetcher;
		this.dataProcessor = dataProcessor;
		this.apiIntegrator = apiIntegrator;
		this.anomalyDetector = anomalyDetector;
		this.predictor = predictor;
	}

	public static void main(String[] args) {
		SpringApplication.run(OceanGuardAnalyticsEngine.class, args);
	}

	@Override
	public void run(String... args) {
		String rawData = dataFetcher.fetchData();
		String processedData = dataProcessor.process(rawData);
		apiIntegrator.integrateData(processedData);
		String anomalies = anomalyDetector.detect(processedData);
		String predictions = predictor.predict(processedData);
		System.out.println("Anomalias: " + anomalies);
		System.out.println("Predições: " + predictions);
	}

}
