package com.db.thebookclub.dto.autor;

import com.db.thebookclub.enums.Genero;

import java.time.LocalDate;

public record AutorAtualizado(

        String nome,

        LocalDate nascimento,

        Genero genero
) {}