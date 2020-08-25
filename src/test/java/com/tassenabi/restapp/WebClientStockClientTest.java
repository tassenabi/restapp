package com.tassenabi.restapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.*;

class WebClientStockClientTest {

    /**
    private WebClient webClient = WebClient.builder().build();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldRetrieveStockPriceFromTheService(){
        WebClientStockClient webClientStockClient = new WebClientStockClient(webClient);
        Flux<StockPrices> prices = webClientStockClient.pricesFor("SYMBOL");

        Assertions.assertNotNull(prices);
        Assertions.assertTrue(prices.take(5).count().block()>0);
    }
    **/
}