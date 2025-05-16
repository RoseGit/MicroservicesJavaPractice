package com.rose.microservices.currency.exchange.service;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;

@SpringBootTest
class CurrencyExchangeServiceApplicationTests {
	
	@MockBean
	private CurrencyExchangeRepository repository;
	
	@MockBean 
	private Environment environment;
	
	@MockBean
	private CurrencyExchangeController controller;

	@Test
	void testRetrieveExchangeValue_returnsValidResponse() {
		 // Arrange
        String from = "USD";
        String to = "INR";
        CurrencyExchange mockExchange = new CurrencyExchange(1L, from, to, BigDecimal.valueOf(82.5));
        when(repository.findByFromAndTo(from, to)).thenReturn(mockExchange);
        when(environment.getProperty("local.server.port")).thenReturn("8000");

        // Act
        CurrencyExchange result = controller.retrieveExchangeValue(from, to);

        // Assert
        assertEquals("USD", result.getFrom());
        assertEquals("INR", result.getTo());
        assertEquals(BigDecimal.valueOf(82.5), result.getConversionMultiple());
        assertEquals("8000", result.getEnvironment());
	}

	@Test
    void testRetrieveExchangeValue_notFound() {
        // Arrange
        when(repository.findByFromAndTo("USD", "EUR")).thenReturn(null);

        // Act & Assert
        ResourceNotFoundException ex = assertThrows(ResourceNotFoundException.class, () ->
            controller.retrieveExchangeValue("USD", "EUR")
        );

        assertEquals("Unable to find data for USD to EUR", ex.getMessage());
        assertEquals(1000, ex.getCode());
    }
}
