package br.com.diseases.core.domain.datasource;

import br.com.diseases.core.domain.model.filter.DiseaseFilter;
import br.com.diseases.infrastructure.dataproviders.entity.DiseaseEntity;
import org.springframework.data.domain.Page;

public interface DiseaseDatasource {

    DiseaseEntity save(DiseaseEntity entity);

    Page<DiseaseEntity> filter(DiseaseFilter filter);

    void delete(Integer id);
}
