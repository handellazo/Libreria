package pe.edu.upeu.libreria.service;
import pe.edu.upeu.libreria.dto.LibroDto;
import pe.edu.upeu.libreria.entity.LibroEntity;

import java.util.List;

public interface LibroService {
    List<LibroEntity> libroListar();
    LibroEntity buscarLibroPorID(int asin);
    LibroEntity guardarLibro(LibroDto libroDto);
    LibroEntity editarLibro(int asin, LibroDto libroDto);
    void eliminarLibro(int asin);
}
