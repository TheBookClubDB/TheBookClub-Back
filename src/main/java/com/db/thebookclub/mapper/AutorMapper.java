package com.db.thebookclub.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.db.thebookclub.dto.autor.AutorRequest;
import com.db.thebookclub.dto.autor.AutorResponse;
import com.db.thebookclub.model.Autor;

@Mapper(componentModel = "spring")
public interface AutorMapper {
    AutorMapper INSTANCE = Mappers.getMapper(AutorMapper.class);

    @Mapping(target = "id", ignore = true)
    Autor requestToAutor(AutorRequest autorRequest);

    AutorResponse autorToResponse(Autor autor);
}
