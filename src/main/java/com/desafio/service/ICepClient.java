package com.desafio.service;

import com.desafio.dto.CepResponseDTO;

public interface ICepClient {
    CepResponseDTO consultar(String cep);
}
