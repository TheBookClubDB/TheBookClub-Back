package com.db.thebookclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.db.thebookclub.dto.autor.AutorRequest;
import com.db.thebookclub.dto.autor.AutorResponse;
import com.db.thebookclub.service.autor.AutorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
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
    @ResponseBody
    public List<AutorResponse> listar(@RequestParam(required = false) String nome) {
        return service.listar(nome);
    }

    @GetMapping("/{id}")
    public AutorResponse buscarPorId(@PathVariable Long id) {
        return service.buscarAutorPorId(id);
    }
}
