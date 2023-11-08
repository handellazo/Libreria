package pe.edu.upeu.libreria.service;

import pe.edu.upeu.libreria.dto.AutorDto;
import pe.edu.upeu.libreria.entity.AutorEntity;

import java.util.List;
public interface AutorService {
    List<AutorEntity> autorListar();
    AutorEntity buscarAutorPorID(int idautor);
    AutorEntity guardarAutor(AutorDto autorDto);
    AutorEntity editarAutor(int idautor, AutorDto autorDto);
    void eliminarAutor(int idautor);
}
