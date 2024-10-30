package br.com.db.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class AutorDto {
    private String nome;
    private String nascimento;
    private String genero;
}