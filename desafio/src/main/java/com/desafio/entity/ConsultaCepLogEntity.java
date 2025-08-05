package com.desafio.entity;


import com.desafio.model.ConsultaCepLog;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "consulta_cep_log")
public class ConsultaCepLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cep;

    private LocalDateTime consultaEm;

    @Column(columnDefinition = "TEXT")
    private String respostaJson;

    public ConsultaCepLogEntity() {}

    public ConsultaCepLogEntity(ConsultaCepLog log) {
        this.cep = log.getCep();
        this.consultaEm = log.getConsultaEm();
        this.respostaJson = log.getRespostaJson();
    }
}
