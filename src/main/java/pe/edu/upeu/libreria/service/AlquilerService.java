package pe.edu.upeu.libreria.service;
import pe.edu.upeu.libreria.dto.AlquilerDto;
import pe.edu.upeu.libreria.entity.AlquilerEntity;

import java.util.List;

public interface AlquilerService {
    List<AlquilerEntity> alquilerListar();
    AlquilerEntity buscarAlquilerPorID(int id);
    AlquilerEntity guardarAlquiler(AlquilerDto alquilerDto);
    AlquilerEntity editarAlquiler(int id, AlquilerDto alquilerDto);
    void eliminarAlquiler(int id);
}
