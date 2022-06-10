package br.com.diseases.core.domain.usecase.disease.input;

import br.com.diseases.infrastructure.dataproviders.entity.SymptomEntity;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SymptomInput {

    @EqualsAndHashCode.Include
    private Integer id;

    private String name;

    public SymptomEntity toEntity() {
        return SymptomEntity
                .builder()
                .id(id)
                .name(name)
                .build();
    }
}
