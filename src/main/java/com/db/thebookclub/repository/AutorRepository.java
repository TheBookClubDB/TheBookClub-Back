package com.db.thebookclub.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.db.thebookclub.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query(value = "SELECT a FROM Autor a WHERE a.nome ILIKE :nome")
    Optional<Autor> findByNome(@Param("nome") String nome);
} 
