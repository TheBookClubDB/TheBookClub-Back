package com.db.thebookclub.service.autor;

import com.db.thebookclub.dto.autor.AutorAtualizado;
import com.db.thebookclub.dto.autor.AutorRequest;
import com.db.thebookclub.dto.autor.AutorResponse;
import com.db.thebookclub.exception.AutorJaCadastradoException;
import com.db.thebookclub.exception.AutorNaoEncontradoException;
import com.db.thebookclub.mapper.AutorMapper;
import com.db.thebookclub.model.Autor;
import com.db.thebookclub.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    AutorRepository repository;

    private final AutorMapper autorMaper = AutorMapper.INSTANCE;

    @Override
    public AutorResponse registrar(AutorRequest request) {
        verificaSeJaExisteAutorComEsseNome(request.nome());
        Autor autor = AutorMapper.INSTANCE.requestToAutor(request);
        repository.save(autor);
        return AutorMapper.INSTANCE.autorToResponse(autor);
    }

    private void verificaSeJaExisteAutorComEsseNome(String nome) {
        Optional<Autor> autor = repository.findByNome(nome);
        if (autor.isPresent()) {
            throw new AutorJaCadastradoException("Já existe um autor cadastrado com esse nome");
        }
    }

    @Override
    public List<AutorResponse> listar(String nome) {
        List<AutorResponse> retorno = new ArrayList<>();

        if (nome == null) {
            retorno = autorMaper.lista(repository.findAll());
        } else {
            retorno = autorMaper.lista(buscar(nome));
        }

        return retorno;
    }

    @Override
    public AutorResponse atualizarAutorPorId(Long id, AutorAtualizado dadosAtualizado) {
        Autor autor = buscar(id);
        autorMaper.atualizarAutor(autor, dadosAtualizado);
        repository.save(autor);
        return autorMaper.autorToResponse(autor);
    }

    public AutorResponse buscarAutorPorId(Long id) {
        return autorMaper.autorToResponse(buscar(id));
    }

    private Autor buscar(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new AutorNaoEncontradoException("Não foi encontrado nenhum autor com o id: " + id));
    }

    private List<Autor> buscar(String nome) {
        List<Autor> autoresEncontrados = repository.findByNomeContainingIgnoreCase(nome);
        if (autoresEncontrados.isEmpty()) {
            throw new AutorNaoEncontradoException("Não foi encontrado nenhum autor com o nome: " + nome);
        }
        return autoresEncontrados;
    }
}