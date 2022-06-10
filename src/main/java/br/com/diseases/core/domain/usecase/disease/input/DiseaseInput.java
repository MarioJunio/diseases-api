package br.com.diseases.core.domain.usecase.disease.input;

import br.com.diseases.infrastructure.dataproviders.entity.DiseaseEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DiseaseInput {

    @EqualsAndHashCode.Include
    private Integer id;

    private String name;
    private String description;

    @Builder.Default
    private List<SymptomInput> symptoms = new ArrayList<>();

    public DiseaseEntity toEntity() {
        return DiseaseEntity.builder()
                .name(name)
                .description(description)
                .symptoms(symptoms.stream().map(symptomInput -> symptomInput.toEntity()).collect(Collectors.toList()))
                .build();
    }
}
