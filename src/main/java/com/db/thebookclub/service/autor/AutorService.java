package com.db.thebookclub.service.autor;

import com.db.thebookclub.dto.autor.AutorRequest;
import com.db.thebookclub.dto.autor.AutorResponse;

import java.util.List;

public interface AutorService {
    AutorResponse registrar(AutorRequest request);
    List<AutorResponse> listar(String nome);

    AutorResponse buscarAutorPorId(Long id);
}
