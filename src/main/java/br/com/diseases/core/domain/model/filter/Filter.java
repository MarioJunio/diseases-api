package br.com.diseases.core.domain.model.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public abstract class Filter {

    private int page;
    private int pageSize = 20;
}
