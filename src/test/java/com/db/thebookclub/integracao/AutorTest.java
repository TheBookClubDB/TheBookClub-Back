package com.db.thebookclub.integracao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.db.thebookclub.dto.autor.AutorRequest;
import com.db.thebookclub.fixture.AutorFixture;
import com.db.thebookclub.fixture.SqlProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class AutorTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private String json;
    private AutorRequest requestValido;

    @Test
    @DisplayName("Deve permitir registrar um novo autor")
    @SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = SqlProvider.clearDB)
    })
    void registraAutorTest() throws Exception {
        requestValido = AutorFixture.autorValido();
        json = objectMapper.writeValueAsString(requestValido);

        mockMvc.perform(MockMvcRequestBuilders.post("/autor/registro")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("João Silva"))
                .andExpect(jsonPath("$.nascimento").value(LocalDate.of(1990, 5, 10).toString()))
                .andExpect(jsonPath("$.genero").value("MASCULINO"));
    }

    @Test
    @DisplayName("Não deve permitir registrar um autor por duplicidade")
    @SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = SqlProvider.insertAutor),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = SqlProvider.clearDB)
    })
    void naoRegistraAutorTest() throws Exception {
        requestValido = AutorFixture.autorValido();
        json = objectMapper.writeValueAsString(requestValido);

        mockMvc.perform(MockMvcRequestBuilders.post("/autor/registro")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(content().string(containsString("Já existe um autor cadastrado com esse nome")));
    }

}