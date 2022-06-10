package br.com.diseases.core.domain.model.filter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DiseaseFilter extends Filter {

    private String description;
    private List<Integer> symptoms;

    @Builder
    DiseaseFilter(int page, int pageSize, String description, List<Integer> symptoms) {
        super(page, pageSize);

        this.description = description;
        this.symptoms = symptoms;
    }
}
