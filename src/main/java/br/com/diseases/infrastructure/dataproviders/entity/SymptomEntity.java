package br.com.diseases.infrastructure.dataproviders.entity;

import br.com.diseases.core.domain.model.Symptom;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "symptom")
public class SymptomEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(unique = true)
    private String name;

    public Symptom toModel() {
        return Symptom
                .builder()
                .id(id)
                .name(name)
                .build();
    }
}
