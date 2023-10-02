package pe.edu.upeu.libreria.service;
import pe.edu.upeu.libreria.entity.LectorEntity;

import java.util.List;

public interface LectorService {
    List<LectorEntity> lectorListar();
    LectorEntity buscarLectorPorID(int dnilector);
    LectorEntity guardarLector(LectorEntity lectorEntity);
    LectorEntity editarLector(int dnilector, LectorEntity lectorEntity);
    void eliminarLector(int dnilector);
}
