package br.com.db.stubs;

import br.com.db.dto.AutorDto;
import com.github.javafaker.Faker;

public class AutorStub {
    private static final AutorDto autor = new AutorDto();

    public static AutorDto getAutorStub() {
        autor.setNome(Faker.instance().name().name());
        autor.setNascimento("1990-07-17");
        autor.setGenero("MASCULINO");
        return autor;
    }
}