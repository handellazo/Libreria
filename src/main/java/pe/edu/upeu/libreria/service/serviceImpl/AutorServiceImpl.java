package pe.edu.upeu.libreria.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.libreria.entity.AutorEntity;
import pe.edu.upeu.libreria.repository.AutorInterface;
import pe.edu.upeu.libreria.service.AutorService;

import java.util.List;
@Service
public class AutorServiceImpl implements AutorService {
    @Autowired
    private AutorInterface autorInterface;

    @Override
    public List<AutorEntity> autorListar() {
        return autorInterface.findAll();
    }

    @Override
    public AutorEntity buscarAutorPorID(int idautor) {
        return autorInterface.findById(idautor)
                .orElse(null);
    }

    @Override
    public AutorEntity guardarAutor(AutorEntity autorEntity) {
        AutorEntity nuevoAutor = new AutorEntity();
        nuevoAutor.setAutor(autorEntity.getAutor());
        return autorInterface.save(nuevoAutor);
    }

    @Override
    public AutorEntity editarAutor(int idautor, AutorEntity autorEntity) {
        AutorEntity autorEncontrado = autorInterface.findById(idautor).orElse(null);
        if (autorEncontrado != null){
            autorEncontrado.setAutor(autorEntity.getAutor());
            return autorInterface.save(autorEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarAutor(int idautor) {
        autorInterface.deleteById(idautor);
    }
}
