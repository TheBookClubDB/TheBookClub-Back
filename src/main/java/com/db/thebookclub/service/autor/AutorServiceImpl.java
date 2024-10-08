package com.db.thebookclub.service.autor;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.db.thebookclub.dto.autor.AutorRequest;
import com.db.thebookclub.dto.autor.AutorResponse;
import com.db.thebookclub.exception.AutorJaCadastradoException;
import com.db.thebookclub.mapper.AutorMapper;
import com.db.thebookclub.model.Autor;
import com.db.thebookclub.repository.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService {
    
    @Autowired
    AutorRepository repository;

    private final AutorMapper autorMaper = AutorMapper.INSTANCE;

    @Override
    public AutorResponse registrar(AutorRequest request) {
        verificaSeJaExisteAutorComEsseCpf(request.cpf());
        Autor autor = AutorMapper.INSTANCE.requestToAutor(request);
        repository.save(autor);
        return AutorMapper.INSTANCE.autorToResponse(autor);
    }

    private void verificaSeJaExisteAutorComEsseCpf(String cpf) {
        Optional<Autor> autor = repository.findByCpf(cpf);
        if (autor.isPresent()) {
            throw new AutorJaCadastradoException("Já existe um autor cadastrado com esse CPF");
        }
    }

    public List<AutorResponse> lista(){
        return autorMaper.lista(repository.findAll());

    }
}
