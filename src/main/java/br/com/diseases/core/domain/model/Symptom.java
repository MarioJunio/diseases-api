package br.com.diseases.core.domain.model;

import br.com.diseases.infrastructure.entrypoints.api.response.SymptomResponse;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Symptom {

    @EqualsAndHashCode.Include
    private Integer id;

    private String name;

    public SymptomResponse toApiResponse() {
        return SymptomResponse
                .builder()
                .id(id)
                .name(name)
                .build();
    }
}
