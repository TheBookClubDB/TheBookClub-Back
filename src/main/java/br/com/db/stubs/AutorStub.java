package br.com.db.stubs;

import br.com.db.dto.AutorDto;
import com.github.javafaker.Faker;

public class AutorStub {

    public static AutorDto getAutorStub() {
        AutorDto autor = new AutorDto();
        autor.setNome(Faker.instance().name().name());
        autor.setNascimento("1990-07-17");
        autor.setGenero("MASCULINO");
        return autor;
    }
}