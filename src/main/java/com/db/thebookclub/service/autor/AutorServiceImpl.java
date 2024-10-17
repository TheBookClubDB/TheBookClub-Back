package com.db.thebookclub.service.autor;

import java.util.List;
import java.util.Optional;

import com.db.thebookclub.exception.AutorNaoEncontradoException;
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

    @Override
    public List<AutorResponse> listar(String nome) {
        List<AutorResponse> pessoasBuscada;

        if(nome == null){
            pessoasBuscada= autorMaper.lista(repository.findAll());
        }else{
            pessoasBuscada = buscarAutorPeloNome(nome);
        }

        return pessoasBuscada;
    }

    public AutorResponse buscarAutorPorId(Long id){
        Autor autor = repository.findById(id).orElseThrow(
                ()-> new AutorNaoEncontradoException("Não foi encontrado nenhum autor com o id: "+id));
        return autorMaper.autorToResponse(autor);
    }

    private List<AutorResponse> buscarAutorPeloNome(String nome){
        List<Autor> autoresEncontrados = repository.findByNomeContainingIgnoreCase(nome);
        if(autoresEncontrados.isEmpty()){
            throw  new AutorNaoEncontradoException("Não foi encontrado nenhum autor com o nome: "+nome);
        }
        return autorMaper.lista(autoresEncontrados);
    }
}