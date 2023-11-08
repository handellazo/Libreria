package pe.edu.upeu.libreria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="AUTOR")
public class AutorEntity implements Serializable {
    private static final long serialVersionUID = -2170897015344177815L;

    @Id
    @Column(name = "IDAUTOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAutor")
    @SequenceGenerator(sequenceName = "SEQ_AUTOR", allocationSize = 1, name = "seqAutor")
    private Integer idautor;

    @Column(name = "AUTOR")
    private String autor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "id_autor")
    @JsonIgnore
    private Set<LibroEntity> autores;
}
