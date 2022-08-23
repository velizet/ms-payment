package com.bank.mspayment.services.impl;

import com.bank.mspayment.models.utils.ResponseActive;
import com.bank.mspayment.services.ActiveService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class ActiveServiceImpl implements ActiveService {

    private final WebClient webClient;

    public ActiveServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://localhost:8083").build();
    }

    @Override
    public Mono<ResponseActive> findByCode(String id)
    {
        return webClient.get()
                .uri("/api/active/"+ id)
                .retrieve()
                .bodyToMono(ResponseActive.class);
    }

}
