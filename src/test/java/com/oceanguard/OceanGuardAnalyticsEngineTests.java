package com.oceanguard;

import com.oceanguard.data.DataFetcher;
import com.oceanguard.data.DataProcessor;
import com.oceanguard.integration.ApiIntegrator;
import com.oceanguard.ml.AnomalyDetector;
import com.oceanguard.ml.Predictor;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;

@SpringBootTest
public class OceanGuardAnalyticsEngineTests {

	@Mock
	private DataFetcher dataFetcher;

	@Mock
	private DataProcessor dataProcessor;

	@Mock
	private ApiIntegrator apiIntegrator;

	@Mock
	private AnomalyDetector anomalyDetector;

	@Mock
	private Predictor predictor;

	@InjectMocks
	private OceanGuardAnalyticsEngine oceanGuardAnalyticsEngine;

	@Test
	void testRun() throws Exception {
		// Dados de exemplo
		String rawData = "Dados brutos";
		String processedData = "Dados processados";

		// Mock dos métodos das classes mockadas
		when(dataFetcher.fetchData()).thenReturn(rawData);
		when(dataProcessor.process(rawData)).thenReturn(processedData);

		// Teste do método run
		oceanGuardAnalyticsEngine.run();

		// Verificação se os métodos foram chamados corretamente
		verify(dataFetcher, times(1)).fetchData();
		verify(dataProcessor, times(1)).process(rawData);
		verify(apiIntegrator, times(1)).integrateData(processedData);
		verify(anomalyDetector, times(1)).detect(processedData);
		verify(predictor, times(1)).predict(processedData);
	}
}
