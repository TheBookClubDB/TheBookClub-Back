package com.db.thebookclub.fixture;

import java.time.LocalDate;

import com.db.thebookclub.dto.autor.AutorRequest;
import com.db.thebookclub.enums.Genero;

public class AutorFixture {
    
    public static AutorRequest autorValido() {
        return new AutorRequest(
            "João Silva",                        
            LocalDate.of(1990, 5, 10),           
            "513.099.230-00",                   
            Genero.MASCULINO                    
        );
    }

    public static AutorRequest autorInvalido() {
        return new AutorRequest(
            "",                                  
            null,                                
            "123.456.789-99",                    
            null                                
        );
    }
}
