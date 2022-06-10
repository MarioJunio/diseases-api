package br.com.diseases.core.domain.usecase.disease;

import br.com.diseases.core.domain.datasource.DiseaseDatasource;
import br.com.diseases.core.domain.model.Disease;
import br.com.diseases.core.domain.model.filter.DiseaseFilter;
import br.com.diseases.core.domain.model.page.AppPage;
import br.com.diseases.core.domain.usecase.Usecase;
import br.com.diseases.core.utils.ModelMapperUtils;
import br.com.diseases.infrastructure.dataproviders.entity.DiseaseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class GetDiseasesUsecase implements Usecase<DiseaseFilter, Page<Disease>> {

    private final DiseaseDatasource diseaseDatasource;

    @Override
    public Page<Disease> execute(DiseaseFilter diseaseFilter) {
        final Page<DiseaseEntity> diseaseEntityPage = diseaseDatasource.filter(diseaseFilter);

        return AppPage.<Disease>builder()
                .content(ModelMapperUtils.mapList(diseaseEntityPage.getContent(), Disease.class))
                .pageable(diseaseEntityPage.getPageable())
                .total(diseaseEntityPage.getTotalElements())
                .build();
    }
}
