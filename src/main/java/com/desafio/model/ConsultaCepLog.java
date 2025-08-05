package com.desafio.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ConsultaCepLog {

    private final String cep;
    private final LocalDateTime consultaEm;
    private final String respostaJson;

}
