package br.com.diseases.infrastructure.entrypoints.api.response;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DiseaseResponse {

    @EqualsAndHashCode.Include
    private Integer id;

    private String name;
    private String description;

    @Builder.Default
    private List<SymptomResponse> symptoms = new ArrayList<>();
}
