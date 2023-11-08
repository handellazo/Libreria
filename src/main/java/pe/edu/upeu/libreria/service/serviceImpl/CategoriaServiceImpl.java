package pe.edu.upeu.libreria.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.libreria.dto.CategoriaDto;
import pe.edu.upeu.libreria.entity.CategoriaEntity;
import pe.edu.upeu.libreria.repository.CategoriaInterface;
import pe.edu.upeu.libreria.service.CategoriaService;

import java.util.List;
@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaInterface categoriaInterface;

    @Override
    public List<CategoriaEntity> categoriaListar() {
        return categoriaInterface.findAll();
    }

    @Override
    public CategoriaEntity buscarCategoriaPorID(int idcategoria) {
        return categoriaInterface.findById(idcategoria)
                .orElse(null);
    }

    @Override
    public CategoriaEntity guardarCategoria(CategoriaDto categoriaDto) {

        CategoriaEntity nuevoCategoria = new CategoriaEntity();
        nuevoCategoria.setCategoria(categoriaDto.getCategoria());
        return categoriaInterface.save(nuevoCategoria);
    }

    @Override
    public CategoriaEntity editarCategoria(int idcategoria, CategoriaDto categoriaDto) {
        CategoriaEntity categoriaEncontrado = categoriaInterface.findById(idcategoria).orElse(null);
        if (categoriaEncontrado != null){
            categoriaEncontrado.setCategoria(categoriaDto.getCategoria());
            return categoriaInterface.save(categoriaEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarCategoria(int idcategoria) {
        categoriaInterface.deleteById(idcategoria);
    }
}
