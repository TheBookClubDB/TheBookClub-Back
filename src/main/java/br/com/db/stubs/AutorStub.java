package br.com.db.stubs;

import br.com.db.dto.AutorDto;

public class AutorStub {
    private static final AutorDto autor = new AutorDto();

    public static AutorDto getAutorStub() {
        autor.setNome("Teste 14");
        autor.setNascimento("1990-07-17");
        autor.setGenero("MASCULINO");
        return autor;
    }
}