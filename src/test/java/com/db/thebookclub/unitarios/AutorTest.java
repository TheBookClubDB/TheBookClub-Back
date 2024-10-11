package com.db.thebookclub.unitarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
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
    private AutorServiceImpl  service;

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
        when(repository.findByNome(requestValido.nome())).thenReturn(Optional.empty());

        response = service.registrar(requestValido);

        verify(repository, times(1)).save(any(Autor.class));
        assertEquals(response.nome(), requestValido.nome());
        assertEquals(response.nascimento(), requestValido.nascimento());
        assertEquals(response.genero(), requestValido.genero());
    }

    @Test
    @DisplayName("Não deve permitir registrar um autor por dados invalidos")
    void naoRegistraAutor() {
        when(repository.findByNome(requestValido.nome())).thenReturn(Optional.of(autor));

        assertThrows(AutorJaCadastradoException.class, () -> {
            service.registrar(requestValido);
        });

        verify(repository, never()).save(any(Autor.class));
    }

}
