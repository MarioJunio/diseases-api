package br.com.diseases.infrastructure.dataproviders.repository;

import br.com.diseases.infrastructure.dataproviders.entity.DiseaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends JpaRepository<DiseaseEntity, Integer> {
}
