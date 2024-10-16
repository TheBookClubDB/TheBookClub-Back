package com.db.thebookclub.dto.autor;

import java.time.LocalDate;
import com.db.thebookclub.enums.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AutorRequest(

    @NotBlank(message = "Por favor, preencha seu nome.")
    String nome,

    @NotNull(message = "Por favor, preencha sua data de nascimento.")
    LocalDate nascimento,

    Genero genero
) {}
