package br.com.diseases.core.domain.usecase;

public interface Usecase<T, R> {

    R execute(T t);
}
