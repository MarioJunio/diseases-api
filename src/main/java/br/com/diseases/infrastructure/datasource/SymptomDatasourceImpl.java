package br.com.diseases.infrastructure.datasource;

import br.com.diseases.core.domain.datasource.SymptomDatasource;
import br.com.diseases.infrastructure.dataproviders.entity.SymptomEntity;
import br.com.diseases.infrastructure.dataproviders.repository.SymptomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SymptomDatasourceImpl implements SymptomDatasource {

    private final SymptomRepository symptomRepository;

    @Override
    public SymptomEntity save(SymptomEntity symptomEntity) {
        return null;
    }

    @Override
    public List<SymptomEntity> getAll() {
        return symptomRepository.findAll();
    }

    @Override
    public void delete(Integer id) {

    }
}
