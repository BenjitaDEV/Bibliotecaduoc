package cl.example.Bibliotecaduoc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

/**
 * DTO para actualizar un libro existente (PUT) No incluye ID porque se obtiene del path parameter
 */
public record UpdateLibroRequest(@NotBlank(message = "ISBN no puede ser vacio") String isbn,
                @NotBlank(message = "Titulo no puede ser vacio") String titulo,
                @NotBlank(message = "Editorial no puede ser vacio") String editorial,
                @PositiveOrZero(message = "Año de publicacion no puede ser negativo") int fechaPublicacion,
                @NotBlank(message = "Autor no puede ser vacio") String autor) {
}
