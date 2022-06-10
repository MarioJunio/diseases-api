package br.com.diseases.infrastructure.entrypoints.api.request;

import br.com.diseases.core.domain.usecase.disease.input.SymptomInput;
import br.com.diseases.core.utils.ModelMapperUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SymptomRequest {

    @EqualsAndHashCode.Include
    private Integer id;

    private String name;

    public SymptomInput toInput() {
        return ModelMapperUtils.mapTo(this, SymptomInput.class);
    }
}
