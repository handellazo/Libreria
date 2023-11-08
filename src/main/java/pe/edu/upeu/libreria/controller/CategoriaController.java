package pe.edu.upeu.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.libreria.dto.CategoriaDto;
import pe.edu.upeu.libreria.entity.CategoriaEntity;
import pe.edu.upeu.libreria.service.CategoriaService;

import java.util.List;

@RestController
@RequestMapping("/api/CATEGORIA")
@CrossOrigin(origins = {"http://localhost:4200, http://localhost:8080 "})
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listCategoria") //GET
    public ResponseEntity<List<CategoriaEntity>> listarCategoria(){
        List<CategoriaEntity> categorias = categoriaService.categoriaListar();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @PostMapping("/addCategoria")
    public ResponseEntity<CategoriaEntity> crearCategoria(@RequestBody CategoriaDto categoria){
        CategoriaEntity newCategoria = categoriaService.guardarCategoria(categoria);
        if (newCategoria != null){
            return new ResponseEntity<>(newCategoria, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateCategoria/{idcategoria}") //PUT
    public ResponseEntity<CategoriaEntity> updateCategoria(@PathVariable Integer idcategoria, @RequestBody CategoriaDto newCategoria){
        CategoriaEntity updateCategoria = categoriaService.editarCategoria(idcategoria, newCategoria);
        if (updateCategoria != null){
            return new ResponseEntity<>(updateCategoria, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAutor/{idcategoria}") //DELETE
    public ResponseEntity<Void> deleteAutor(@PathVariable Integer idcategoria){
        categoriaService.eliminarCategoria(idcategoria);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
