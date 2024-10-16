package com.db.thebookclub.fixture;

import java.time.LocalDate;
import com.db.thebookclub.dto.autor.AutorRequest;
import com.db.thebookclub.enums.Genero;

public class AutorFixture {
    
    public static AutorRequest autorValido() {
        return new AutorRequest(
            "João Silva",                        
            LocalDate.of(1990, 5, 10),                             
            Genero.MASCULINO                    
        );
    }

    public static AutorRequest autorInvalido() {
        return new AutorRequest(
            "",                                  
            null,                                                 
            null                                
        );
    }
}
