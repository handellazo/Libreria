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
@Table(name="EDITORIAL")
@Entity
public class EditorialEntity implements Serializable {
    @Id
    @Column(name = "IDEDITORIAL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEditorial")
    @SequenceGenerator(sequenceName = "SEQ_EDITORIAL", allocationSize = 1, name = "seqEditorial")
    private Integer ideditorial;

    @Column(name = "EDITORIAL")
    private String editorial;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "editorial")
    @JsonIgnore
    private Set<LibroEntity> editoriales;

}
