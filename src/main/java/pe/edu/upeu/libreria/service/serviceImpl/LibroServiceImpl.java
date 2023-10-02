package pe.edu.upeu.libreria.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
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
import pe.edu.upeu.libreria.service.AutorService;
import pe.edu.upeu.libreria.service.LibroService;

import java.util.List;
@Service
public class LibroServiceImpl implements LibroService {
    @Autowired
    private LibroInterface libroInterface;
    @Autowired
    private AutorInterface autorInterface;
    @Autowired
    private EditorialInterface editorialInterface;
    @Autowired
    private CategoriaInterface categoriaInterface;

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
        CategoriaEntity categoriaEncontrado = categoriaInterface.findById(libroDto.getCategoria()).orElse(null);
        EditorialEntity editorialEncontrado = editorialInterface.findById(libroDto.getEditorial()).orElse(null);

        LibroEntity nuevoLibro = new LibroEntity();
        nuevoLibro.setAsin(libroDto.getAsin());
        nuevoLibro.setTitulo(libroDto.getTitulo());
        nuevoLibro.setLanzamiento(libroDto.getLanzamiento());
        nuevoLibro.setId_autor(autorEncontrado);//autor
        nuevoLibro.setCategoria(categoriaEncontrado);//categoria
        nuevoLibro.setEditorial(editorialEncontrado);//editorial
        nuevoLibro.setIdioma(libroDto.getIdioma());
        nuevoLibro.setPaginas(libroDto.getPaginas());
        nuevoLibro.setDescripcion(libroDto.getDescripcion());
        nuevoLibro.setPortada(libroDto.getPortada());
        return libroInterface.save(nuevoLibro);
    }

    @Override
    public LibroEntity editarLibro(int asin, LibroDto libroEntity) {
        LibroEntity libroEncontrado = libroInterface.findById(asin).orElse(null);
        AutorEntity autorEncontrado = autorInterface.findById(libroEntity.getId_autor()).orElse(null);
        CategoriaEntity categoriaEncontrado = categoriaInterface.findById(libroEntity.getCategoria()).orElse(null);
        EditorialEntity editorialEncontrado = editorialInterface.findById(libroEntity.getEditorial()).orElse(null);

        if (libroEncontrado != null){
            libroEncontrado.setTitulo(libroEntity.getTitulo());
            libroEncontrado.setLanzamiento(libroEntity.getLanzamiento());
            libroEncontrado.setId_autor(autorEncontrado);//autor
            libroEncontrado.setCategoria(categoriaEncontrado);//categoria
            libroEncontrado.setEditorial(editorialEncontrado);//editorial
            libroEncontrado.setIdioma(libroEntity.getIdioma());
            libroEncontrado.setPaginas(libroEntity.getPaginas());
            libroEncontrado.setDescripcion(libroEntity.getDescripcion());
            libroEncontrado.setPortada(libroEntity.getPortada());
            return libroInterface.save(libroEncontrado);
        }
        return null;
    }

    @Override
    public void eliminarLibro(int asin) {
        libroInterface.deleteById(asin);
    }
}
