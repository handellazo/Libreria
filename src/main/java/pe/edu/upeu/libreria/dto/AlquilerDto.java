package pe.edu.upeu.libreria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlquilerDto {

    private Integer idalquiler;

    private String alquiler;

    private Integer dni_lector; //FK

    private Integer id_asin; //FK

    private Date salida;

    private Date entrada;
}
