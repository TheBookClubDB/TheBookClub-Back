package com.db.thebookclub.mapper;

import com.db.thebookclub.dto.autor.AutorAtualizado;
import com.db.thebookclub.dto.autor.AutorRequest;
import com.db.thebookclub.dto.autor.AutorResponse;
import com.db.thebookclub.model.Autor;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AutorMapper {
    AutorMapper INSTANCE = Mappers.getMapper(AutorMapper.class);

    @Mapping(target = "id", ignore = true)
    Autor requestToAutor(AutorRequest autorRequest);

    AutorResponse autorToResponse(Autor autor);

    List<AutorResponse> lista(List<Autor> autores);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void atualizarAutor(@MappingTarget Autor autor, AutorAtualizado atualizado);
}
