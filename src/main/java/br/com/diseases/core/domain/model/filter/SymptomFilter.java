package br.com.diseases.core.domain.model.filter;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SymptomFilter extends Filter {

    @Builder
    SymptomFilter(int page, int pageSize) {
        super(page, pageSize);
    }
}
