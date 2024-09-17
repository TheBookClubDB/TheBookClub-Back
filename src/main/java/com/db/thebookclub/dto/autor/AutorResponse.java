package com.db.thebookclub.dto.autor;

import java.time.LocalDate;

import com.db.thebookclub.enums.Genero;

public record AutorResponse(
    Long id,
    String nome,
    LocalDate nascimento,
    String cpf,
    Genero genero
) {}
