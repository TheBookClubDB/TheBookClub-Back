package com.db.thebookclub.service.autor;

public class AutorServiceClass {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listAutor() {
        return autorRepository.listAutores();
    }

    public Optional<Autor> findById(Long id) {
        return autorRepository.findById(id);
    }

    public Autor findByAutor(String autor) {
        return autorRepository.findByName(autor);
    }
}
