package com.tassenabi.restapp;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * Will be the RestClient
 */
public class WebClientUser {
/**
    private WebClient webClient;

    public WebClientStockClient(WebClient webClient){
        this.webClient = webClient;
    }
    public Flux<StockPrices> allUser(String user) {
        return webClient.get()
                .uri("http://localhost:8080/user/{symbol}", symbol)
                .retrieve()
                .bodyToFlux(User.class);
    }
 **/
}
