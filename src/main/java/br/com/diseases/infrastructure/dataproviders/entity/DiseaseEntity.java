package br.com.diseases.infrastructure.dataproviders.entity;

import br.com.diseases.core.domain.model.Disease;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "disease")
public class DiseaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(unique = true)
    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "disease_symptoms",
            joinColumns = @JoinColumn(name = "disease_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "symptom_id", referencedColumnName = "id")
    )
    @Builder.Default
    private List<SymptomEntity> symptoms = new ArrayList<>();

    public Disease toModel() {
        return Disease
                .builder()
                .id(id)
                .name(name)
                .description(description)
                .symptoms(symptoms
                        .stream()
                        .map(symptomEntity -> symptomEntity.toModel())
                        .collect(Collectors.toList()))
                .build();
    }
}
