package pe.edu.upeu.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.libreria.entity.AutorEntity;
import pe.edu.upeu.libreria.service.AutorService;

import java.util.List;

@RestController
@RequestMapping("/api/AUTOR")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping("/listAutor") //GET
    public ResponseEntity<List<AutorEntity>> listarAutor(){
        List<AutorEntity> autores = autorService.autorListar();
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    @PostMapping("/addAutor")
    public ResponseEntity<AutorEntity> crearAutor(@RequestBody AutorEntity autor){
        AutorEntity newAutor = autorService.guardarAutor(autor);
        if (newAutor != null){
            return new ResponseEntity<>(newAutor, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateAutor/{id}") //PUT
    public ResponseEntity<AutorEntity> updateAutor(@PathVariable Integer id, @RequestBody AutorEntity newAutor){
        AutorEntity updateAutor = autorService.editarAutor(id, newAutor);
        if (updateAutor != null){
            return new ResponseEntity<>(updateAutor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAutor/{id}") //DELETE
    public ResponseEntity<Void> deleteAutor(@PathVariable Integer id){
        autorService.eliminarAutor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
