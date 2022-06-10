package br.com.diseases.core.domain.usecase.symptom;

import br.com.diseases.core.domain.datasource.SymptomDatasource;
import br.com.diseases.core.domain.model.Symptom;
import br.com.diseases.core.domain.usecase.Usecase;
import br.com.diseases.core.utils.ModelMapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class GetAllSymptomsUsecase implements Usecase<Void, List<Symptom>> {

    private final SymptomDatasource symptomDatasource;

    @Override
    public List<Symptom> execute(Void unused) {
        return ModelMapperUtils.mapList(symptomDatasource.getAll(), Symptom.class);
    }
}
