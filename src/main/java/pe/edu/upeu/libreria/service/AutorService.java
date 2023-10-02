package pe.edu.upeu.libreria.service;

import pe.edu.upeu.libreria.entity.AutorEntity;

import java.util.List;
public interface AutorService {
    List<AutorEntity> autorListar();
    AutorEntity buscarAutorPorID(int idautor);
    AutorEntity guardarAutor(AutorEntity autorEntity);
    AutorEntity editarAutor(int idautor, AutorEntity autorEntity);
    void eliminarAutor(int idautor);
}
