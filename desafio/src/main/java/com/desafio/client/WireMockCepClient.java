package com.desafio.client;

import com.desafio.dto.CepResponseDTO;
import com.desafio.service.ICepClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Profile("mock")
public class WireMockCepClient implements ICepClient {

    private final RestTemplate rest;

    public WireMockCepClient(RestTemplateBuilder builder) {
        this.rest = builder.build();
    }

    @Override
    public CepResponseDTO consultar(String cep) {
        return rest.getForObject("http://localhost:8081/cep/" + cep, CepResponseDTO.class);
    }

}

