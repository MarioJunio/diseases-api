package br.com.diseases.infrastructure.datasource;

import br.com.diseases.core.domain.datasource.DiseaseDatasource;
import br.com.diseases.core.domain.model.filter.DiseaseFilter;
import br.com.diseases.infrastructure.dataproviders.entity.DiseaseEntity;
import br.com.diseases.infrastructure.dataproviders.repository.DiseaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DiseaseDatasourceImpl implements DiseaseDatasource {

    private final DiseaseRepository diseaseRepository;

    @Override
    public DiseaseEntity save(DiseaseEntity entity) {
        return diseaseRepository.save(entity);
    }

    @Override
    public Page<DiseaseEntity> filter(DiseaseFilter filter) {
        return diseaseRepository.findAll(PageRequest.of(filter.getPage(), filter.getPageSize()));
    }

    @Override
    public void delete(Integer id) {
        diseaseRepository.deleteById(id);
    }
}
