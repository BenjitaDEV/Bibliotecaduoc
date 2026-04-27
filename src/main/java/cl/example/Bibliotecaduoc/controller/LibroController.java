package cl.example.Bibliotecaduoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import cl.example.Bibliotecaduoc.dto.CreateLibroRequest;
import cl.example.Bibliotecaduoc.dto.UpdateLibroRequest;
import cl.example.Bibliotecaduoc.exception.ResourceNotFoundException;
import cl.example.Bibliotecaduoc.mapper.LibroMapper;
import cl.example.Bibliotecaduoc.model.Libro;
import cl.example.Bibliotecaduoc.services.LibroService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {
    
    private final LibroService libroService;
    private final WebClient pokeApiWebClient;

    //constructor injection(mejor practica 2026)
    public LibroController(LibroService libroService, WebClient pokeApiWebClient){
        this.libroService = libroService;
        this.pokeApiWebClient = pokeApiWebClient;
    }

    @GetMapping
    public ResponseEntity<List<Libro>> listarLibros() {
        List<Libro> libros = libroService.getLibros();
        return ResponseEntity.ok(libros);
    }

    @PostMapping
    public ResponseEntity<Libro> agregarLibro(@Valid @RequestBody CreateLibroRequest request){
        // @Valid ejecuta validaciones Jakarta automáticamente
        // Si falla → GlobalExceptionHandler.handleValidationErrors() retorna 400

        Libro nuevoLibro = libroService.saveLibro(LibroMapper.toModel(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLibro);
    }

    @GetMapping ("{id}")
    public ResponseEntity<Libro> buscarLibro(@PathVariable int id){
        Libro libro = libroService.getLibroId(id);

        if(libro == null){
            throw new ResourceNotFoundException("libro no encontrado para id: " + id); 
        }
        return ResponseEntity.ok(libro);
    }

    @PutMapping("{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable int id,
                        @Valid @RequestBody UpdateLibroRequest request){
            // El ID viene del path, no del body → evita ambigüedad
            Libro libroActualizado = libroService.updateLibro(LibroMapper.toModel(id, request));
            return ResponseEntity.ok(libroActualizado); 
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable int id){
        libroService.deleteLibro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping ("/total")
    public ResponseEntity<Integer> totalLibros(){
        
    }
}
