package br.com.diseases.infrastructure.entrypoints.api;

import br.com.diseases.core.domain.model.Symptom;
import br.com.diseases.core.domain.usecase.symptom.GetAllSymptomsUsecase;
import br.com.diseases.core.utils.ModelMapperUtils;
import br.com.diseases.infrastructure.entrypoints.api.response.SymptomResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("/symptoms")
@Slf4j
public class SymptomApi {

    private final GetAllSymptomsUsecase getAllSymptomsUsecase;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SymptomResponse> getAll() {
        final List<Symptom> symptoms = getAllSymptomsUsecase.execute(null);

        return ModelMapperUtils.mapList(symptoms, SymptomResponse.class);
    }
}
