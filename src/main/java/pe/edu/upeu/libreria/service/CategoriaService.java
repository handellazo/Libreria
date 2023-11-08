package pe.edu.upeu.libreria.service;
import pe.edu.upeu.libreria.dto.CategoriaDto;
import pe.edu.upeu.libreria.entity.CategoriaEntity;

import java.util.List;

public interface CategoriaService {
    List<CategoriaEntity> categoriaListar();
    CategoriaEntity buscarCategoriaPorID(int idcategoria);
    CategoriaEntity guardarCategoria(CategoriaDto categoriaDto);
    CategoriaEntity editarCategoria(int idcategoria, CategoriaDto categoriaDto);
    void eliminarCategoria(int idcategoria);
}
