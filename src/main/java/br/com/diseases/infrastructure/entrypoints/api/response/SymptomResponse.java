package br.com.diseases.infrastructure.entrypoints.api.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SymptomResponse {

    @EqualsAndHashCode.Include
    private Integer id;

    private String name;


}
