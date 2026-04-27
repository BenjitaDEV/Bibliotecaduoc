package cl.example.Bibliotecaduoc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

//DTO para crear un nuevo libro (post), el id se genera automaticamente
//public record
public record CreateLibroRequest (
    @NotBlank(message = "ISBN no puede ser vacío") String isbn,
    @NotBlank(message = "Titulo no puede ser vacío") String titulo,
    @NotBlank(message = "Editorial no puede ser vacio") String editorial,
    @PositiveOrZero(message = "Año de publicacion no puede ser negativo") int fechaPublicacion,
    @NotBlank(message = "Autor no puede ser vacio") String autor) {
}
