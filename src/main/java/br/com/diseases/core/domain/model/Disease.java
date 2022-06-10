package br.com.diseases.core.domain.model;

import br.com.diseases.core.utils.ModelMapperUtils;
import br.com.diseases.infrastructure.dataproviders.entity.DiseaseEntity;
import br.com.diseases.infrastructure.entrypoints.api.response.DiseaseResponse;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Disease {

    @EqualsAndHashCode.Include
    private Integer id;

    private String name;
    private String description;

    @Builder.Default
    private List<Symptom> symptoms = new ArrayList<>();

    public static Disease of(DiseaseEntity entity) {
        return ModelMapperUtils.mapTo(entity, Disease.class);
    }

    public DiseaseResponse toApiResponse() {
        return ModelMapperUtils.mapTo(this, DiseaseResponse.class);
    }
}
