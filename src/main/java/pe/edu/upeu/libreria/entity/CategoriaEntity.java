package pe.edu.upeu.libreria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CATEGORIA")
@Entity
public class CategoriaEntity implements Serializable {

    @Id
    @Column(name = "IDCATEGORIA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCategoria")
    @SequenceGenerator(sequenceName = "SEQ_CATEGORIA", allocationSize = 1, name = "seqCategoria")
    private Integer idcategoria;

    @Column(name = "CATEGORIA")
    private String categoria;
}
