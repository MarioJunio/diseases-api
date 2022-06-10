package br.com.diseases;

import br.com.diseases.core.utils.ModelMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DiseasesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiseasesApiApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return ModelMapperUtils.getModelMapperInstance();
    }

}
