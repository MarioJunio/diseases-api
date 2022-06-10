package br.com.diseases.core.domain.model.page;

import lombok.Builder;
import lombok.ToString;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@ToString
public class AppPage<T> extends PageImpl<T> {

    @Builder
    public AppPage(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }
}
