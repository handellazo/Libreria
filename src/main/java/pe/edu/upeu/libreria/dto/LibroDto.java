package pe.edu.upeu.libreria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroDto {

    private Integer asin;

    private String titulo;

    private Date lanzamiento;

    private Integer id_autor; //FK

    private Integer id_categoria; //FK

    private Integer id_editorial; //FK

    private String idioma;

    private Integer paginas;

    private String descripcion;

    private String portada;
}
