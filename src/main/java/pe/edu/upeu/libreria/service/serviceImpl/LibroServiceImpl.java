package pe.edu.upeu.libreria.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import pe.edu.upeu.libreria.dto.LibroDto;
import pe.edu.upeu.libreria.entity.AutorEntity;
import pe.edu.upeu.libreria.entity.CategoriaEntity;
import pe.edu.upeu.libreria.entity.EditorialEntity;
import pe.edu.upeu.libreria.entity.LibroEntity;
import pe.edu.upeu.libreria.repository.AutorInterface;
import pe.edu.upeu.libreria.repository.CategoriaInterface;
import pe.edu.upeu.libreria.repository.EditorialInterface;
import pe.edu.upeu.libreria.repository.LibroInterface;
import pe.edu.upeu.libreria.service.LibroService;

import java.util.List;
@Service
public class LibroServiceImpl implements LibroService {
    @Autowired //Se usa para listar los libros y verificar que exista el libro
    private LibroInterface libroInterface;
    @Autowired //Verificar que exista el autor
    private AutorInterface autorInterface;
    @Autowired //Verificar que exista la editorial
    private EditorialInterface editorialInterface;
    @Autowired //Verificar que exista la categoria
    private CategoriaInterface categoriaInterface;

    //Inicializacion de los objetos
    @Override
    public List<LibroEntity> libroListar() {
        return libroInterface.findAll();
    }

    @Override
    public LibroEntity buscarLibroPorID(int asin) {
        return libroInterface.findById(asin)
                .orElseThrow(null);
    }

    @Override
    public LibroEntity guardarLibro(LibroDto libroDto) {
        AutorEntity autorEncontrado = autorInterface.findById(libroDto.getId_autor()).orElse(null);
        CategoriaEntity categoriaEncontrado = categoriaInterface.findById(libroDto.getId_categoria()).orElse(null);
        EditorialEntity editorialEncontrado = editorialInterface.findById(libroDto.getId_editorial()).orElse(null);
        try {
            LibroEntity nuevoLibro = new LibroEntity();
            nuevoLibro.setAsin(libroDto.getAsin());
            nuevoLibro.setTitulo(libroDto.getTitulo());
            nuevoLibro.setLanzamiento(libroDto.getLanzamiento());
            nuevoLibro.setId_autor(autorEncontrado);//autor
            nuevoLibro.setId_categoria(categoriaEncontrado);//categoria
            nuevoLibro.setId_editorial(editorialEncontrado);//editorial
            nuevoLibro.setIdioma(libroDto.getIdioma());
            nuevoLibro.setPaginas(libroDto.getPaginas());
            nuevoLibro.setDescripcion(libroDto.getDescripcion());
            nuevoLibro.setPortada(libroDto.getPortada());
            return libroInterface.save(nuevoLibro);
        } catch (DataIntegrityViolationException e){
            throw new IllegalArgumentException("El Libro ya existe: " + e);
        }
    }

    @Override
    public LibroEntity editarLibro(int asin, LibroDto libroDto) {
        LibroEntity libroEncontrado = libroInterface.findById(asin).orElse(null);
        AutorEntity autorEncontrado = autorInterface.findById(libroDto.getId_autor()).orElse(null);
        CategoriaEntity categoriaEncontrado = categoriaInterface.findById(libroDto.getId_categoria()).orElse(null);
        EditorialEntity editorialEncontrado = editorialInterface.findById(libroDto.getId_editorial()).orElse(null);

        if (libroEncontrado != null){
            libroEncontrado.setTitulo(libroDto.getTitulo());
            libroEncontrado.setLanzamiento(libroDto.getLanzamiento());
            libroEncontrado.setId_autor(autorEncontrado);//autor FK
            libroEncontrado.setId_categoria(categoriaEncontrado);//categoria FK
            libroEncontrado.setId_editorial(editorialEncontrado);//editorial FK
            libroEncontrado.setIdioma(libroDto.getIdioma());
            libroEncontrado.setPaginas(libroDto.getPaginas());
            libroEncontrado.setDescripcion(libroDto.getDescripcion());
            libroEncontrado.setPortada(libroDto.getPortada());
            return libroInterface.save(libroEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarLibro(int asin) {
        libroInterface.deleteById(asin);
    }
}
