package br.com.diseases.core.utils;

import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ModelMapperUtils {

    final static ModelMapper modelMapper;

    static {
        modelMapper = getModelMapperInstance();
    }

    public static ModelMapper getModelMapperInstance() {
        return new ModelMapper();
    }

    public <S, T> T mapTo(S source, Class<T> target) {
        return modelMapper.map(source, target);
    }

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
}
