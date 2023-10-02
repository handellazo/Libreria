package pe.edu.upeu.libreria.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="LECTOR")
@Entity
public class LectorEntity implements Serializable {

    @Id
    @Column(unique = true, name = "DNILECTOR")
    private Integer dnilector;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "TELEFONO")
    private Integer telefono;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "CODIGOPOSTAL")
    private Integer codigopostal;

    @Column(name = "OBSERVACIONES")
    private String observaciones;

}
