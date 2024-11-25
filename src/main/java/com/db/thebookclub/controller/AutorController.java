package com.db.thebookclub.controller;

import com.db.thebookclub.dto.autor.AutorAtualizado;
import com.db.thebookclub.dto.autor.AutorRequest;
import com.db.thebookclub.dto.autor.AutorResponse;
import com.db.thebookclub.service.autor.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorService service;

    @PostMapping("/registro")
    public ResponseEntity<AutorResponse> registrar(@RequestBody @Valid AutorRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(request));
    }

    @GetMapping()
    public ResponseEntity<List<AutorResponse>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listar(""));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorResponse> atualizar(@PathVariable Long id, @RequestBody AutorAtualizado atualizacao){
        return  ResponseEntity.status(HttpStatus.OK).body(service.atualizarAutorPorId(id, atualizacao));
    }

}