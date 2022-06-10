package br.com.diseases.core.domain.usecase.disease;

import br.com.diseases.core.domain.datasource.DiseaseDatasource;
import br.com.diseases.core.domain.model.Disease;
import br.com.diseases.core.domain.usecase.Usecase;
import br.com.diseases.core.domain.usecase.disease.input.DiseaseInput;
import br.com.diseases.infrastructure.dataproviders.entity.DiseaseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CreateDiseaseUsecase implements Usecase<DiseaseInput, Disease> {

    private final DiseaseDatasource diseaseDatasource;

    public Disease execute(DiseaseInput input) {
        final DiseaseEntity diseaseEntity = diseaseDatasource.save(input.toEntity());
        log.info("C=CreateDiseaseUsecase, M=execute, diseaseEntity={}", diseaseEntity);

        return Disease.of(diseaseEntity);
    }
}
