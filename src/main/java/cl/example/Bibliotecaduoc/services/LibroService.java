package cl.example.Bibliotecaduoc.services;

import java.util.List;
import cl.example.Bibliotecaduoc.model.Libro;
import cl.example.Bibliotecaduoc.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getLibros(){
        return libroRepository.findAll();
    }

    public Libro saveLibro(Libro libro){
        return libroRepository.save(libro);
    }

    public Libro getLibroId(int id){
        return libroRepository.findById(id).orElse(null);
    }
    
    public Libro updateLibro(Libro libro){
        return libroRepository.save(libro);
    }

    public String deleteLibro(int id){
        libroRepository.deleteById(id);
        return "Libro eliminado";
    }

    // LA ACCIÓN LA HACE EL SERVICE
    public int totalLibros() {
        // return libroRepository.obtenerLibros().size();
        return (int) libroRepository.count();
    }

    // LA ACCIÓN LA HACE EL MODELO
    public int totalLibrosV2() {
        return libroRepository.totalLibros();
    }

    public List<Libro> obtenerPorEditorial(String editorial){
        return libroRepository.selectPorEditorial(editorial);
    }

}
