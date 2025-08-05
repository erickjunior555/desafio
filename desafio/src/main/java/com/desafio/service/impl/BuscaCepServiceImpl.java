package com.desafio.service.impl;


import com.desafio.dto.CepResponseDTO;
import com.desafio.model.ConsultaCepLog;
import com.desafio.service.BuscaCepService;
import com.desafio.service.ICepClient;
import com.desafio.service.ILogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BuscaCepServiceImpl implements BuscaCepService {

    private final ICepClient cepClient;
    private final ILogRepository logRepository;

    public BuscaCepServiceImpl(ICepClient cepClient, ILogRepository logRepository) {
        this.cepClient = cepClient;
        this.logRepository = logRepository;
    }


    @Override
    public CepResponseDTO buscar(String cep) {

        if (!cep.matches("^\\d{5}-?\\d{3}$")) {
            throw new IllegalArgumentException("Formato de CEP inválido. Use 00000000 ou 00000-000.");
        }

        CepResponseDTO resposta = cepClient.consultar(cep);

        logRepository.salvar(new ConsultaCepLog(
                cep,
                LocalDateTime.now(),
                resposta.toJson()
        ));

        return resposta;
    }
}

