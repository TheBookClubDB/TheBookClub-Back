package com.db.thebookclub.service.autor;

import com.db.thebookclub.dto.autor.AutorRequest;
import com.db.thebookclub.dto.autor.AutorResponse;

public interface AutorService {
    AutorResponse registrar(AutorRequest request);
} 
