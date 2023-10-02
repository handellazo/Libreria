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
@Table(name="ALQUILER")
@Entity
public class AlquilerEntity implements Serializable {

    @Id
    @Column(name = "IDALQUILER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAlquiler")
    @SequenceGenerator(sequenceName = "SEQ_ALQUILER", allocationSize = 1, name = "seqAlquiler")
    private Integer idalquiler;

    @Column(name = "ALQUILER")
    private String alquiler;

    @ManyToOne
    @JoinColumn(name = "ID_LECTOR")
    private LectorEntity id_lector;

    @ManyToOne
    @JoinColumn(name = "ID_LIBRO")
    private LibroEntity libro;

    @Column(name = "FECHASALIDA")
    private Date salida;

    @Column(name = "FECHAENTRADA")
    private Date entrada;
}
