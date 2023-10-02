package pe.edu.upeu.libreria.service;
import pe.edu.upeu.libreria.entity.EditorialEntity;

import java.util.List;

public interface EditorialService {
    List<EditorialEntity> editorialListar();
    EditorialEntity buscarEditorialPorID(int ideditorial);
    EditorialEntity guardarEditorial(EditorialEntity alquilerEntity);
    EditorialEntity editarEditorial(int ideditorial, EditorialEntity editorialEntity);
    void eliminarEditorial(int ideditorial);
}
