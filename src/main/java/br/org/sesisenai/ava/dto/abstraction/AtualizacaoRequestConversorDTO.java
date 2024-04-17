package br.org.sesisenai.ava.dto.abstraction;

public interface AtualizacaoRequestConversorDTO<E> {
    E toEntity(E entity);
}
