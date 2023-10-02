package pe.edu.upeu.libreria.service;
import pe.edu.upeu.libreria.entity.AlquilerEntity;

import java.util.List;

public interface AlquilerService {
    List<AlquilerEntity> alquilerListar();
    AlquilerEntity buscarAlquilerPorID(int id);
    AlquilerEntity guardarAlquiler(AlquilerEntity alquilerEntity);
    AlquilerEntity editarAlquiler(int id, AlquilerEntity alquilerEntity);
    void eliminarAlquiler(int id);
}
