package com.desafio.repository;

import com.desafio.entity.ConsultaCepLogEntity;
import com.desafio.model.ConsultaCepLog;
import com.desafio.service.ConsultaCepLogEntityRepository;
import com.desafio.service.ILogRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaLogRepository implements ILogRepository {

    private final ConsultaCepLogEntityRepository entityRepository;

    public JpaLogRepository(ConsultaCepLogEntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public void salvar(ConsultaCepLog log) {
        entityRepository.save(new ConsultaCepLogEntity(log));
    }

}
