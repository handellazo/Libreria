package pe.edu.upeu.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.libreria.entity.EditorialEntity;
import pe.edu.upeu.libreria.service.EditorialService;

import java.util.List;

@RestController
@RequestMapping("/api/EDITORIAL")
public class EditorialController {
    @Autowired
    private EditorialService editorialService;

    @GetMapping("/listEditorial") //GET
    public ResponseEntity<List<EditorialEntity>> listarEditorial(){
        List<EditorialEntity> editoriales = editorialService.editorialListar();
        return new ResponseEntity<>(editoriales, HttpStatus.OK);
    }

    @PostMapping("/addEditorial")
    public ResponseEntity<EditorialEntity> crearEditorial(@RequestBody EditorialEntity editorial){
        EditorialEntity newEditorial = editorialService.guardarEditorial(editorial);
        if (newEditorial != null){
            return new ResponseEntity<>(newEditorial, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateEditorial/{ideditorial}") //PUT
    public ResponseEntity<EditorialEntity> updateEditorial(@PathVariable Integer ideditorial, @RequestBody EditorialEntity newEditorial){
        EditorialEntity updateEditorial = editorialService.editarEditorial(ideditorial, newEditorial);
        if (updateEditorial != null){
            return new ResponseEntity<>(updateEditorial, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteEditorial/{ideditorial}") //DELETE
    public ResponseEntity<Void> deleteEditorial(@PathVariable Integer ideditorial){
        editorialService.eliminarEditorial(ideditorial);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
