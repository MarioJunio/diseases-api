package br.com.diseases.core.domain.usecase;

import br.com.diseases.core.domain.datasource.DiseaseDatasource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class RemoveDiseaseUsecase implements Usecase<Integer, Void> {

    private final DiseaseDatasource diseaseDatasource;

    @Override
    public Void execute(Integer id) {
        diseaseDatasource.delete(id);
        return null;
    }
}
