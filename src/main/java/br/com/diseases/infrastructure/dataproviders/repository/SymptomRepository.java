package br.com.diseases.infrastructure.dataproviders.repository;

import br.com.diseases.infrastructure.dataproviders.entity.SymptomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomRepository extends JpaRepository<SymptomEntity, Integer> {
}
