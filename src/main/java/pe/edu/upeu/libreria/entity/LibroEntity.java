package pe.edu.upeu.libreria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="LIBRO")
@Entity
public class LibroEntity implements Serializable {

    @Id
    @Column(name = "ASIN")
    private Integer asin;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "FECHALANZAMIENTO")
    private Date lanzamiento;

    @ManyToOne
    @JoinColumn(name = "IDAUTOR")
    private AutorEntity id_autor;

    @ManyToOne
    @JoinColumn(name = "IDCATEGORIA")
    private CategoriaEntity categoria;

    @ManyToOne
    @JoinColumn(name = "IDEDITORIAL")
    private EditorialEntity editorial;

    @Column(name = "IDIOMA")
    private String idioma;

    @Column(name = "PAGINAS")
    private Integer paginas;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "PORTADA")
    private String portada;
}
