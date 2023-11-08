package pe.edu.upeu.libreria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LectorDto {

    private Integer dnilector;

    private String nombre;

    private Integer telefono;

    private String direccion;

    private Integer codigopostal;

    private String observaciones;

}
