package pe.edu.upeu.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.libreria.dto.LibroDto;
import pe.edu.upeu.libreria.entity.LibroEntity;
import pe.edu.upeu.libreria.service.LibroService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/LIBRO")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping("/listLibro") //GET
    public ResponseEntity<List<LibroEntity>> listarLibro(){
        List<LibroEntity> libros = libroService.libroListar();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/searchLibro/{asin}") //GET
    public ResponseEntity<LibroEntity> buscarLibro(@PathVariable Integer asin){
        LibroEntity libro = libroService.buscarLibroPorID(asin);
        return new ResponseEntity<>(libro, HttpStatus.OK);
    }

    @PostMapping("/addLibro") // POST
    public ResponseEntity<Object> crearLibro(@RequestBody LibroDto libro) {
        List<LibroEntity> todosLosLectores = libroService.libroListar();
        boolean asinExistente = todosLosLectores.stream().anyMatch(lectorExistente -> lectorExistente.getAsin().equals(libro.getAsin()));
        if (asinExistente) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "El ASIN ya existe, ingresa otro");
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }
        try {
            LibroEntity newLibro = libroService.guardarLibro(libro);
            if (newLibro != null) {
                return new ResponseEntity<>(newLibro, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            Map<String, String> response = new HashMap<>();
            response.put("message", "Error al guardar el libro");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PatchMapping("/updateLibro/{asin}") //PUT
    public ResponseEntity<LibroEntity> updateLibro(@PathVariable Integer asin, @RequestBody LibroDto newLibro){
        LibroEntity updateLibro = libroService.editarLibro(asin, newLibro);
        if (updateLibro != null){
            return new ResponseEntity<>(updateLibro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteLibro/{asin}") //DELETE
    public ResponseEntity<Void> deleteLector(@PathVariable Integer asin){
        libroService.eliminarLibro(asin);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
