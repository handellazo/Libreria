package pe.edu.upeu.libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.libreria.entity.LectorEntity;
import pe.edu.upeu.libreria.service.LectorService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/LECTOR")
public class LectorController {
    @Autowired
    private LectorService lectorService;

    @GetMapping("/listLector") //GET
    public ResponseEntity<List<LectorEntity>> listarLector(){
        List<LectorEntity> lectores = lectorService.lectorListar();
        return new ResponseEntity<>(lectores, HttpStatus.OK);
    }

    @GetMapping("/searchLector/{dnilector}") //GET
    public ResponseEntity<LectorEntity> buscarLector(@PathVariable Integer dnilector){
        LectorEntity lector = lectorService.buscarLectorPorID(dnilector);
        return new ResponseEntity<>(lector, HttpStatus.OK);
    }

    @PostMapping("/addLector") // POST
    public ResponseEntity<Object> crearLector(@RequestBody LectorEntity lector) {
        LectorEntity existeDni = lectorService.buscarLectorPorID(lector.getDnilector());
        if (existeDni == null) {
            LectorEntity newLector = lectorService.guardarLector(lector);
            if (newLector != null) {
                return new ResponseEntity<>(newLector, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            // DNI ya existe, devolver un mensaje de error JSON
            Map<String, String> response = new HashMap<>();
            response.put("message", "El DNI ya existe, ingresa otro");
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE); // Usamos HttpStatus.NOT_ACCEPTABLE (código 406) para indicar que la solicitud no es aceptable.
        }
    }

    @PutMapping("/updateLector/{dnilector}") //PUT
    public ResponseEntity<LectorEntity> updateLector(@PathVariable Integer dnilector, @RequestBody LectorEntity newLector){
        LectorEntity updateLector = lectorService.editarLector(dnilector, newLector);
        if (updateLector != null){
            return new ResponseEntity<>(updateLector, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteLector/{dnilector}") //DELETE
    public ResponseEntity<Void> deleteLector(@PathVariable Integer dnilector){
        lectorService.eliminarLector(dnilector);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
