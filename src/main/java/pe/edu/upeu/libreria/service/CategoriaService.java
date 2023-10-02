package pe.edu.upeu.libreria.service;
import pe.edu.upeu.libreria.entity.CategoriaEntity;

import java.util.List;

public interface CategoriaService {
    List<CategoriaEntity> categoriaListar();
    CategoriaEntity buscarCategoriaPorID(int idcategoria);
    CategoriaEntity guardarCategoria(CategoriaEntity categoriaEntity);
    CategoriaEntity editarCategoria(int idcategoria, CategoriaEntity categoriaEntity);
    void eliminarCategoria(int idcategoria);
}
