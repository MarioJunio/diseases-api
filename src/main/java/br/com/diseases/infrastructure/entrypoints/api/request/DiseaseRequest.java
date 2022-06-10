package br.com.diseases.infrastructure.entrypoints.api.request;

import br.com.diseases.core.domain.usecase.disease.input.DiseaseInput;
import br.com.diseases.core.utils.ModelMapperUtils;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DiseaseRequest {

    @EqualsAndHashCode.Include
    private Integer id;

    private String name;
    private String description;

    @Builder.Default
    private List<SymptomRequest> symptoms = new ArrayList<>();

    public DiseaseInput toInput() {
        return ModelMapperUtils.mapTo(this, DiseaseInput.class);
    }
}
