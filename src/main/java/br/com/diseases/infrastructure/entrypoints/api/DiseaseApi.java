package br.com.diseases.infrastructure.entrypoints.api;

import br.com.diseases.core.domain.model.Disease;
import br.com.diseases.core.domain.model.filter.DiseaseFilter;
import br.com.diseases.core.domain.model.page.AppPage;
import br.com.diseases.core.domain.usecase.RemoveDiseaseUsecase;
import br.com.diseases.core.domain.usecase.disease.CreateDiseaseUsecase;
import br.com.diseases.core.domain.usecase.disease.GetDiseasesUsecase;
import br.com.diseases.core.domain.usecase.disease.input.DiseaseInput;
import br.com.diseases.core.utils.ModelMapperUtils;
import br.com.diseases.infrastructure.entrypoints.api.request.DiseaseRequest;
import br.com.diseases.infrastructure.entrypoints.api.response.DiseaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RestController
@RequestMapping("/diseases")
@Slf4j
public class DiseaseApi {

    private final CreateDiseaseUsecase createDiseaseUsecase;

    private final GetDiseasesUsecase getDiseasesUsecase;

    private final RemoveDiseaseUsecase removeDiseaseUsecase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DiseaseResponse create(@RequestBody DiseaseRequest diseaseRequest) {
        final DiseaseInput diseaseInput = diseaseRequest.toInput();
        log.info("C=DiseaseApi, M=create, diseaseInput={}", diseaseInput);

        return createDiseaseUsecase.execute(diseaseInput).toApiResponse();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<DiseaseResponse> getAllWithFilters(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "20") Integer pageSize) {
        final DiseaseFilter filter = DiseaseFilter
                .builder()
                .page(page)
                .pageSize(pageSize)
                .build();

        log.info("C=DiseaseApi, M=getAllWithFilters, filter={}", filter);
        final Page<Disease> diseasePage = getDiseasesUsecase.execute(filter);

        return AppPage.<DiseaseResponse>builder()
                .content(ModelMapperUtils.mapList(diseasePage.getContent(), DiseaseResponse.class))
                .pageable(diseasePage.getPageable())
                .total(diseasePage.getTotalElements())
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void remove(@PathVariable Integer id) {
        removeDiseaseUsecase.execute(id);
    }

}
