package pe.edu.upeu.libreria.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.libreria.entity.EditorialEntity;
import pe.edu.upeu.libreria.repository.EditorialInterface;
import pe.edu.upeu.libreria.service.EditorialService;

import java.util.List;
@Service
public class EditorialServiceImpl implements EditorialService {
    @Autowired
    private EditorialInterface editorialInterface;

    @Override
    public List<EditorialEntity> editorialListar() {
        return editorialInterface.findAll();
    }

    @Override
    public EditorialEntity buscarEditorialPorID(int ideditorial) {
        return editorialInterface.findById(ideditorial)
                .orElse(null);
    }

    @Override
    public EditorialEntity guardarEditorial(EditorialEntity editorialEntity) {
        EditorialEntity nuevoEditorial = new EditorialEntity();
        nuevoEditorial.setEditorial(editorialEntity.getEditorial());
        return editorialInterface.save(nuevoEditorial);
    }

    @Override
    public EditorialEntity editarEditorial(int ideditorial, EditorialEntity editorialEntity) {
        EditorialEntity editorialEncontrado = editorialInterface.findById(ideditorial).orElse(null);
        if (editorialEncontrado != null){
            editorialEncontrado.setEditorial(editorialEntity.getEditorial());
            return editorialInterface.save(editorialEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarEditorial(int ideditorial) {
        editorialInterface.deleteById(ideditorial);
    }
}
