package cl.example.Bibliotecaduoc.mapper;

import cl.example.Bibliotecaduoc.dto.CreateLibroRequest;
import cl.example.Bibliotecaduoc.dto.UpdateLibroRequest;
import cl.example.Bibliotecaduoc.model.Libro;

/**
 * Mapper para convertir DTOs a modelo de dominio (Libro) Sigue el patrón de separación de
 * responsabilidades
 */
public class LibroMapper {
    /**
     * Convierte CreateLibroRequest a Libro (para POST) El ID se genera automáticamente, se pasa 0
     * temporalmente
     */
    public static Libro toModel(CreateLibroRequest request){
        return new Libro(0, // ID temporal, será asignado por el service/repository
             request.isbn(), request.titulo(), request.editorial(), request.fechaPublicacion(),
            request.autor());
    }

    //Convierte UpdatelibroRequest a Libro (para put) el Id se obtien del path parameter
    public static Libro toModel(int id, UpdateLibroRequest request){
        return new Libro(id, //Id del path parameter)
                request.isbn(), request.titulo(), request.editorial(), request.fechaPublicacion(),
                request.autor());
    }
}
