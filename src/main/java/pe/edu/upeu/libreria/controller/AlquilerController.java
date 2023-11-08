package pe.edu.upeu.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.libreria.dto.AlquilerDto;
import pe.edu.upeu.libreria.entity.AlquilerEntity;
import pe.edu.upeu.libreria.service.AlquilerService;

import java.util.List;


@RestController
@RequestMapping("/api/ALQUILER")
@CrossOrigin(origins = {"http://localhost:4200, http://localhost:8080 "})
public class AlquilerController {
    @Autowired
    private AlquilerService alquilerService;

    @GetMapping("/listAlquiler") //GET
    public ResponseEntity<List<AlquilerEntity>> listarAlquilar(){
        List<AlquilerEntity> alquileres = alquilerService.alquilerListar();
        return new ResponseEntity<>(alquileres, HttpStatus.OK);
    }

    @GetMapping("/searchLibro/{idalquiler}") //GET
    public ResponseEntity<AlquilerEntity> buscarLibro(@PathVariable Integer idalquiler){
        AlquilerEntity alquiler = alquilerService.buscarAlquilerPorID(idalquiler);
        return new ResponseEntity<>(alquiler, HttpStatus.OK);
    }

    @PostMapping("/addAlquiler") // POST
    public ResponseEntity<AlquilerEntity> crearAlquiler(@RequestBody AlquilerDto alquiler){
        AlquilerEntity newAlquiler = alquilerService.guardarAlquiler(alquiler);
        if (newAlquiler != null){
            return new ResponseEntity<>(newAlquiler, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateAlquiler/{idalquiler}") //PUT
    public ResponseEntity<AlquilerEntity> updateAlquiler(@PathVariable Integer idalquiler, @RequestBody AlquilerDto newAlquiler){
        AlquilerEntity updateAlquiler = alquilerService.editarAlquiler(idalquiler, newAlquiler);
        if (updateAlquiler != null){
            return new ResponseEntity<>(updateAlquiler, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAlquiler/{idalquiler}") //DELETE
    public ResponseEntity<Void> deleteAlquiler(@PathVariable Integer idalquiler){
        alquilerService.eliminarAlquiler(idalquiler);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
