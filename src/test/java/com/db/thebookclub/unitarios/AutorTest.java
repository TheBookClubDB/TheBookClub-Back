package com.db.thebookclub.unitarios;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.db.thebookclub.exception.AutorNaoEncontradoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.db.thebookclub.dto.autor.AutorRequest;
import com.db.thebookclub.dto.autor.AutorResponse;
import com.db.thebookclub.exception.AutorJaCadastradoException;
import com.db.thebookclub.fixture.AutorFixture;
import com.db.thebookclub.model.Autor;
import com.db.thebookclub.repository.AutorRepository;
import com.db.thebookclub.service.autor.AutorServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AutorTest {

    @Mock
    private AutorRepository repository;

    @InjectMocks
    private AutorServiceImpl service;
    private AutorRequest requestValido;
    private AutorResponse response;
    private Autor autor;

    @BeforeEach
    void setup() {
        requestValido = AutorFixture.autorValido();
        autor = new Autor();
    }

    @Test
    @DisplayName("Deve permitir registrar um autor")
    void registraAutor() {
        when(repository.findByCpf(anyString())).thenReturn(Optional.empty());

        response = service.registrar(requestValido);

        verify(repository, times(1)).save(any(Autor.class));
        assertEquals(response.nome(), requestValido.nome());
        assertEquals(response.cpf(), requestValido.cpf());
    }

    @Test
    @DisplayName("Não deve permitir registrar um autor por dados invalidos")
    void naoRegistraAutor() {
        when(repository.findByCpf(anyString())).thenReturn(Optional.of(autor));

        assertThrows(AutorJaCadastradoException.class, () -> {
            service.registrar(requestValido);
        });

        verify(repository, never()).save(any(Autor.class));
    }

    @Test
    @DisplayName("Deve retornar lista de autores")
    void retornaListaDeAutores() {
        List<Autor> autores = new ArrayList<>();
        autor = autor.builder()
                .nome(requestValido.nome())
                .nascimento(requestValido.nascimento())
                .genero(requestValido.genero())
                .build();

        autores.add(autor);
        when(repository.findAll()).thenReturn(autores);

        List<AutorResponse> autorBuscado = service.listar(null);
        assertEquals(autorBuscado.size(), 1);
        assertTrue(autorBuscado.get(0).nome().equals(requestValido.nome()));
        assertTrue(autorBuscado.get(0).genero().toString().equals(requestValido.genero().toString()));
    }

    @Test
    @DisplayName("Deve retornar um autor buscado por id")
    void retornaAutorBuscadoPorId() {
        autor = autor.builder()
                .id(1L)
                .nome(requestValido.nome())
                .nascimento(requestValido.nascimento())
                .genero(requestValido.genero())
                .build();
        when(repository.findById(1L)).thenReturn(Optional.of(autor));

        AutorResponse resposta = service.buscarAutorPorId(1L);

        assertTrue(resposta != null);
        assertEquals(resposta.nome(), autor.getNome());
        assertEquals(resposta.nascimento(), autor.getNascimento());
        assertEquals(1L, resposta.id());
    }

    @Test
    @DisplayName("Deve retornar um erro de autor buscado pelo ID e não encontrado")
    void retornaExcessaoDeAutorNaoEncontrado() {

        AutorNaoEncontradoException exception = assertThrows(AutorNaoEncontradoException.class, () ->
                service.buscarAutorPorId(1L));

        assertEquals("Não foi encontrado nenhum autor com o id: " + 1L, exception.getMessage());
    }

    @Test
    @DisplayName("Deve retornar um autor buscado pelo nome")
    void retornaListaDeAutoresBucadoPeloBome() {
        autor = autor.builder()
                .id(1L)
                .nome(requestValido.nome())
                .nascimento(requestValido.nascimento())
                .genero(requestValido.genero())
                .build();
        when(repository.findByNome(autor.getNome())).thenReturn(Optional.of(autor));

        Autor resposta = repository.findByNome(autor.getNome()).get();

        assertEquals(autor.getNome(), resposta.getNome());
        assertEquals(resposta.getNascimento(), autor.getNascimento());
        assertEquals(resposta.getGenero().toString(), autor.getGenero().toString());
    }

    @Test
    @DisplayName("Deve lançar Excessão de autor buscado pelo nome não encontrado")
    void retornaExcessaoDeAutorBucadoPeloNomeNaoEncontrado() {
        String nomeBuscado = "nomeNaoCadastrado";

        AutorNaoEncontradoException exception = assertThrows(AutorNaoEncontradoException.class,
                () -> service.listar(nomeBuscado));

        assertEquals("Não foi encontrado nenhum autor com o nome: " + nomeBuscado, exception.getMessage());

    }
}