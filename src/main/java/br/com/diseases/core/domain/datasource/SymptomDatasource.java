package br.com.diseases.core.domain.datasource;

import br.com.diseases.infrastructure.dataproviders.entity.SymptomEntity;

import java.util.List;

public interface SymptomDatasource {
    SymptomEntity save(SymptomEntity symptomEntity);

    List<SymptomEntity> getAll();

    void delete(Integer id);
}
