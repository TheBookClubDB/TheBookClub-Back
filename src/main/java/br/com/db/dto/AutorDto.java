package br.com.db.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonPropertyOrder({"nome", "nascimento", "genero"})
public class AutorDto {
    private String nome;
    private String nascimento;
    private String genero;
}