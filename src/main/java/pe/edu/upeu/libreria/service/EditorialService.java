package pe.edu.upeu.libreria.service;
import pe.edu.upeu.libreria.dto.EditorialDto;
import pe.edu.upeu.libreria.entity.EditorialEntity;

import java.util.List;

public interface EditorialService {
    List<EditorialEntity> editorialListar();
    EditorialEntity buscarEditorialPorID(int ideditorial);
    EditorialEntity guardarEditorial(EditorialDto editorialDto);
    EditorialEntity editarEditorial(int ideditorial, EditorialDto editorialDto);
    void eliminarEditorial(int ideditorial);
}
