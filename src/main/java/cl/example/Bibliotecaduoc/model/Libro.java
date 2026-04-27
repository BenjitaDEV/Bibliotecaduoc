
package cl.example.Bibliotecaduoc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data //genera Getter, Setters, Tostring, equals, hashCode y un constructor con los campos requeridos.
// @AllArgsConstructor // Genera un constructor con todos los campos.
// @NoArgsConstructor // genera un constructor con todos los campos

@Entity
@Table(name = "Libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "isbn", nullable = false, length = 20)
    private String isbn;

    @Column(name = "titulo", nullable = false, length = 200)
    private String titulo;

    @Column(name = "editorial", nullable = false, length = 100)
    private String editorial;

    @Column(name = "fecha_publicacion", nullable = false)
    private int fechaPublicacion;

    @Column(name = "autor", nullable = false, length = 150)
    private String autor;

    //constructor vacio
    public Libro(){}

    //constructor completo
    public Libro(int id, String isbn, String titulo, String editorial, int fechaPublicacion,
            String autor) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
    }
    // Getters y Setters (manuales porque Lombok no está funcionando)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(int fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}